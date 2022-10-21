public class RemindVisitor extends NodeVisitor{

    Reminder m_Reminder = new Reminder();


    @Override
    void visitProduct(Product product) {
        product.accept(this);
    }

    @Override
    void visitTrading(Trading trading) {
        trading.accept(this);
    }

    @Override
    void visitFacade(Facade facade) {
        facade.thePerson.userProductList.accept(this);
    }

    public void makeReminder(Trading trade,String msg){
        this.m_Reminder.remind(trade,msg);
    }
}
