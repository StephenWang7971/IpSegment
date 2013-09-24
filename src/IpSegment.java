public class IpSegment {
    private Ip from;
    private Ip to;

    public IpSegment(Ip lower, Ip upper) {
        from = lower;
        to = upper;
    }

    public boolean isIn(Ip ip) {
        return from.toInt() <= ip.toInt() && to.toInt() >= ip.toInt();
    }

    public static class Ip {
        private int _1;
        private int _2;
        private int _3;
        private int _4;

        public Ip(int _1, int _2, int _3, int _4) {
            if (!isValid(_1) || !isValid(_2) || !isValid(_3) || !isValid(_4)) {
                throw new IllegalArgumentException();
            }
            this._1 = _1;
            this._2 = _2;
            this._3 = _3;
            this._4 = _4;
        }

        private boolean isValid(int ipSeg) {
            return ipSeg >= 0 && ipSeg < 256;
        }

        public int toInt() {
            return _1 << (8 * 3) + _2 << (8 * 2) << _3 << 8 + _4;
        }
    }

    public static void main(String[] args) {
        IpSegment seg = new IpSegment(new Ip(1, 1, 1, 1), new Ip(1, 255, 255, 255));
        System.out.println(seg.isIn(new Ip(1, 1, 23, 42)));
        System.out.println(seg.isIn(new Ip(1, 255, 23, 42)));
        System.out.println(seg.isIn(new Ip(1, 1, 255, 42)));
        System.out.println(seg.isIn(new Ip(1, 1, 23, 255)));
        System.out.println(seg.isIn(new Ip(1, 255, 255, 255)));
    }
}
