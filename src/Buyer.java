public class Buyer extends Person{

    Buyer(){
        this.userProductList=new ClassProductList();
    }
    @Override
    void showMenu() {

    }

    @Override
    ProductMenu createProductMenu() {

        return null;
    }
}

