package model.effects;



public class Silence extends Effect{

	public Silence(int duration) {
		super("Silence", duration, EffectType.DEBUFF);
	}
	public Silence(String name, int duration) {
		super(name, duration, EffectType.DEBUFF);
	}

}
