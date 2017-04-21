package io.github.zhangyuz.gsync.utils;

public class L {
    public static void v(final String tag, String... msgs) {
        StringBuffer sb = new StringBuffer(tag);
        sb.append(":");
        for (String msg :
                msgs) {
            sb.append(msg);
        }
        sb.append("\n");
        System.out.print(sb.toString());
    }

    public static void d(final String tag, String... msgs) {
        StringBuffer sb = new StringBuffer(tag);
        sb.append(":");
        for (String msg :
                msgs) {
            sb.append(msg);
        }
        sb.append("\n");
        System.out.print(sb.toString());
    }

    public static void w(final String tag, String... msgs) {
        StringBuffer sb = new StringBuffer(tag);
        sb.append(":");
        for (String msg :
                msgs) {
            sb.append(msg);
        }
        sb.append("\n");
        System.out.print(sb.toString());
    }

    public static void e(final String tag, String... msgs) {
        StringBuffer sb = new StringBuffer(tag);
        sb.append(":");
        for (String msg :
                msgs) {
            sb.append(msg);
        }
        sb.append("\n");
        System.err.print(sb.toString());
    }

    public static void i(final String tag, String... msgs) {
        StringBuffer sb = new StringBuffer(tag);
        sb.append(":");
        for (String msg :
                msgs) {
            sb.append(msg);
        }
        sb.append("\n");
        System.out.print(sb.toString());
    }
}
