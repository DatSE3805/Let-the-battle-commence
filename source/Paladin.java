public class Paladin extends Knight {
	public Paladin(int baseHp, int wp) {
		super(baseHp, wp);
	}

	@Override
	public double getCombatScore() {
		if (Utility.isFibonacci(getBaseHp())){
			int index = Utility.indexFibonacci(getBaseHp());
			if (index > 2) {
				return 1000.0 + index;
			}
		}
		
		return getBaseHp() * 3.0;
	}
}