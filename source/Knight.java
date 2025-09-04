public class Knight extends Fighter {
    public Knight(int baseHp, int wp) {
        super(baseHp, wp);
    }

    @Override
    public double getCombatScore() {
        if (Utility.isSquare(Battle.GROUND)) {
            double res = getBaseHp() * 2.0;
            if (res > 999.0)
                return 999.0;
            else {
                return res;
            }
        }

        if (getWp() == 1) {
            return getBaseHp();
        }
        else {
            return getBaseHp() / 10.0;
        }
    }
}