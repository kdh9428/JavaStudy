package StreamEx;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApiExample2 {
	 public static void main(String[] args) {
	        List<Product> products = Arrays.asList(
	                new Product(1L, "A", new BigDecimal("100.50")),
	                new Product(1L, "B", new BigDecimal("23.00")),
	                new Product(1L, "C", new BigDecimal("31.45")),
	                new Product(1L, "D", new BigDecimal("80.20")),
	                new Product(1L, "E", new BigDecimal("7.50"))
	        );
		 System.out.println(products.get(0).getPrice().intValue());
		 System.out.println(
		 			((products.get(0).getPrice().intValue())*1)+
							((products.get(2).getPrice().intValue())*3)+
							((products.get(4).getPrice().intValue())*10)

		 );
	        
	        System.out.println(
	        products.stream()
	        		.filter(produt -> produt.getPrice().compareTo(new BigDecimal("30")) >= 0)
	        		.collect(Collectors.toList())
	        );
	        
	        System.out.println("==========================================");
	        System.out.println("Products.price >= 30 (with joining(\"\\n\"))\n"+
	        		products.stream()
	        		.filter(produt -> produt.getPrice().compareTo(new BigDecimal("30")) >= 0)
	        		.map(product -> product.toString())
	        		.collect(Collectors.joining("\n"))
	        );
	        
	        System.out.println();
	        System.out.println("IntStream.sum : "+
	        IntStream.of(1, 2, 3, 4, 5)
	        		.sum()
	        );
	        
	        System.out.println();
	        System.out.println("Total Price :"+
	        products.stream()
	        		.map(product -> product.getPrice())
	        		.reduce(BigDecimal.ZERO, (price1, price2)-> price1.add(price2))
//	        		.reduce(BigDecimal.ZERO,(product1, product2) -> product1.getPrice().add(product2.getPrice()))
	        		);

		 System.out.println();
		 System.out.println("Total Price >= 30 :"+
				 products.stream()
						 .filter(product -> product.getPrice().compareTo(new BigDecimal("30"))>=0)
						 .count()
		 );

		 List<String> ld = Arrays.asList("bb","aaasdfff","ddasdf","ccc");
		 ld = new ArrayList<>(ld);
		ld.sort((a, b) -> a.compareTo(b));
		 for (String a :
				 ld) {
			 System.out.println(a);
		 }

		 String aa ="asdf";
		 String ab ="asdfff";

		 BigDecimal dd =new BigDecimal("123.01");
		 int sdf = dd.intValue();
		 System.out.println("비교: "+ aa.compareTo(ab));
		 products.stream()
				 .forEach(a -> System.out.println(a.getPrice()));

		 System.out.println("====================================");
		products.stream()
				.forEachOrdered(print -> System.out.println(
						print.getPrice()
				));

		 System.out.println("======================================");
		products.stream()
				.sorted((sor1,sor2)-> sor1.getPrice().compareTo(sor2.getPrice()))
				.map(a ->a.getPrice().intValue())
				.forEach(print -> System.out.println("BigDecimal + 테스트"+print.intValue()));

		 products.sort((a1,a2)-> a1.getPrice().compareTo(a2.getPrice()));


		 System.out.println(products.stream().filter(product -> product.getPrice().compareTo(new BigDecimal("20"))>=0));
		 for (Product a : products) {
			 System.out.println(a.getPrice());
		 }

		 products.stream()
				 .peek(a -> a.getId())
				 .forEach(System.out::println);

		 final OrderedItem item1 = new OrderedItem(1L, products.get(0),1);
		 final OrderedItem item2 = new OrderedItem(2L, products.get(2),3);
		 final OrderedItem item3 = new OrderedItem(3L, products.get(4),10);

		 final Order order = new Order(1L, Arrays.asList(item1,item2,item3));

		 System.out.println("최종 합계 : "+ order.totalPrice());

	 }


//		 System.out.println("컴페이블"+
//		 products.sort((a,b) ->  a.getPrice().subtract(b.getPrice()));
//		 );
	 }

	@Data
	@AllArgsConstructor
	class Product{
	    private Long id;
	    private String name;
	    private BigDecimal price;
	}

	@AllArgsConstructor
	@Data
	class OrderedItem{
	    private Long id;
	    private Product product;
	    private  int quantity;

	    public BigDecimal getTotalPrice(){
			System.out.println("getTotalPrice :" +product.getPrice().multiply(new BigDecimal(quantity)));
	    	return product.getPrice().multiply(new BigDecimal(quantity));
		}
	}

	@AllArgsConstructor
	@Data
	class Order{
	    private Long id;
	    private List<OrderedItem> items;

	    public BigDecimal totalPrice(){
	    	return items.stream()
						.map(item -> item.getTotalPrice())
						.reduce(BigDecimal.ZERO, (price1, price2)-> price1.add(price2));
		}
	}