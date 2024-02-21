package application.utils.functinterface;

@FunctionalInterface
public interface MyInterfaceToDAO<T> {
    T betweenBeginAndCommitted();
}
