package StreamEx;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.function.Function;

public class MethodReferenceExampleConstructor {

    public static void main(String[] args) {

        final Section section = new Section(1);

        final Function<Integer, Section> sectionFunction = number -> new Section(number);
        Function<Integer,Section> anonymous = new Function<Integer, Section>() {
            @Override
            public Section apply(Integer integer) {
                return new Section(integer);
            }
        };

        final Function<Integer, Section> sectionFactoryWithMethod =
                Section::new;
        final Section section1WithMethodReference = sectionFactoryWithMethod.apply(1);

        Section anonymousResult = anonymous.apply(1);
        final Section section1WithFunction = sectionFunction.apply(1);
        System.out.println(" test : "+ anonymousResult);
        System.out.println(section);
        System.out.println(section1WithFunction);


        final OldProduct product = new OldProduct(1L,"A",new BigDecimal("100"));
        System.out.println(product);
        final OldProductCreate productCreator = OldProduct::new;
        System.out.println(productCreator.create(1L, "A",new BigDecimal("100")));

        ProductA a = createProduct(1L, "A", new BigDecimal("123"), ProductA::new);
    }

    private static <T extends ProductCons> T createProduct(final Long id,
                                                final String name,
                                                final BigDecimal price,
                                                final ProductCreator<T> productCreator) {
        if (id == null || id < 1L) {
            throw new IllegalArgumentException("The id must be a positive Long.");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("The name is not given.");
        }
        if (price == null || BigDecimal.ZERO.compareTo(price) >= 0) {
            throw new IllegalArgumentException("The price must be greater then 0.");
        }
        return productCreator.create(id, name, price);
    }
}

@FunctionalInterface
interface ProductCreator<T extends ProductCons>{
    T create(Long id, String name, BigDecimal price);
}

@FunctionalInterface
interface OldProductCreate{
    OldProduct create(Long id, String name, BigDecimal price);
}

@AllArgsConstructor
@Data
class Section{
    private int number;
}

@Data
@AllArgsConstructor
abstract class ProductCons{
    private Long id;
    private String name;
    private BigDecimal price;
}

@AllArgsConstructor
@Data
class OldProduct{
    private Long id;
    private String name;
    private BigDecimal price;
}

class ProductA extends ProductCons{

    public ProductA(long id, String name, BigDecimal price) {
        super(id, name, price);
    }

    @Override
    public String toString() {
        return "A = "+ super.toString();
    }
}
class ProductB extends ProductCons{

    public ProductB(long id, String name, BigDecimal price) {
        super(id, name, price);
    }

    @Override
    public String toString() {
        return "B = "+super.toString();
    }
}