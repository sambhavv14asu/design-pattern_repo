public abstract class NodeVisitor {

    abstract void visitProduct(Product product);
    abstract void visitTrading(Trading trading);
    abstract void visitFacade(Facade facade);

    abstract void makeReminder(Trading trade, String msg);
}
