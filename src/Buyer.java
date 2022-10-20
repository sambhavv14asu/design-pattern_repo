import java.util.Scanner;

public class Buyer extends Person{

    Buyer(){
        this.userProductList=new ClassProductList();
    }
    @Override
    void showMenu(ProductMenu menu) {
        ClassProductList list = menu.items;
        ProductIterator iterator =new ProductIterator(list);
        // Implementing the iterator method to iterate over the product list
        while(iterator.hasNext()){
            Product p = iterator.next();
            String category = p.category == 0 ? "Meat":"Produce";
            System.out.println(p.name+" "+category);
        }
    }

    //factory pattern to decide the instance of productMenu based on category -meat or produce
    //in case of a buyer we show all the products generated in the productList
    @Override
    ProductMenu createProductMenu() {

        Scanner scn=new Scanner(System.in);
        System.out.println("Enter the category - 0 for meat, 1 for produce");

        int category = scn.nextInt();
        ClassProductList allProducts = Facade.theProductList;
        if(category==0){
            theProductMenu=new MeatProductMenu();
            for(Product p:allProducts){
                if(p.category==0){
                    theProductMenu.items.add(p);
                }
            }
        }else{
            theProductMenu=new ProduceProductMenu();
            for(Product p:allProducts){
                if(p.category==1){
                    theProductMenu.items.add(p);
                }
            }
        }

        return theProductMenu;
    }
}

