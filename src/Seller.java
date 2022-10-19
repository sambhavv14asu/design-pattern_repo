public class Seller extends Person{

    Seller(){
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
