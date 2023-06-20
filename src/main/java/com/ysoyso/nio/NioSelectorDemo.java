package com.ysoyso.nio;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioSelectorDemo {

    public static void main(String[] args) throws IOException {

        // 创建选择器
        Selector selector = Selector.open();

        // 创建服务器通道
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress("localhost", 8080);

        // 绑定服务器地址
        serverChannel.bind(address);

        // 设置通道为非阻塞模式
        serverChannel.configureBlocking(false);

        // 注册通道到选择器上，并指定监听事件类型为接收连接事件
        SelectionKey key = serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("服务器启动，监听地址：" + address);

        while (true) {
            // 阻塞等待通道就绪
            int readyChannels = selector.select();
            if (readyChannels == 0) {
                continue;
            }

            // 获取已就绪的通道集合
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

            while (keyIterator.hasNext()) {
                SelectionKey selectionKey = keyIterator.next();

                if (selectionKey.isAcceptable()) { // 接收连接事件就绪
                    // 获取服务器通道
                    ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();

                    // 接收客户端连接，并注册到选择器上
                    SocketChannel client = server.accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ);

                    System.out.println("客户端连接： " + client.getRemoteAddress());

                } else if (selectionKey.isReadable()) { // 通道可读事件就绪
                    // 获取通道
                    SocketChannel client = (SocketChannel) selectionKey.channel();

                    // 读取数据
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int bytesRead = client.read(buffer);

                    if (bytesRead == -1) { // 通道已经关闭
                        client.close();
                    } else if (bytesRead == 0) { // 没有数据可读
                        continue;
                    } else { // 读取到数据
                        buffer.flip();
                        byte[] bytes = new byte[buffer.remaining()];
                        buffer.get(bytes);
                        String message = new String(bytes).trim();
                        System.out.println("收到消息：" + message);
                    }
                }

                // 移除已处理的通道
                keyIterator.remove();
            }
        }
    }
}
