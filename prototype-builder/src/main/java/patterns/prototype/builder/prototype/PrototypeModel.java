package patterns.prototype.builder.prototype;

public abstract class PrototypeModel implements Cloneable {

    @Override
    public abstract PrototypeModel clone();
}
