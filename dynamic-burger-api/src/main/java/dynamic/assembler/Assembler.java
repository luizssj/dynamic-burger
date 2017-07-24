package dynamic.assembler;

public interface Assembler<D, R> {

	D fromResource(R resource);

	Iterable<D> fromResource(Iterable<R> resources);

	R fromDomain(D domain);

	Iterable<R> fromDomain(Iterable<D> domains);
}
