package transactions;

import java.util.*;
import java.util.stream.Collectors;

public class TransactionManager {
	private Map<String, Region> regions = new HashMap<>();
	private Map<String, Place> places = new HashMap<>();
	private Set<Carrier> carriers = new HashSet<>();
	private Map<String,Request> requests = new HashMap<>();
	private Map<String,Offer> offers = new HashMap<>();
	private Map<String,Transaction> transactions = new HashMap<>();
	private Map<EvaluatedTransaction, Integer> evaluatedTransactionMap = new HashMap();



	//R1
	public List<String> addRegion(String regionName, String... placeNames) {
		Region region = new Region(regionName);
		for (String p : placeNames) {
			if (!places.containsKey(p)){
				Place place = new Place(p, region);
				region.addPlace(place);
				places.put(p, place);
			}
		}
		regions.put(regionName, region);
		return region.getPlaces().stream().map(Place::getName).sorted().collect(Collectors.toList());

	}
//version-2
	//	public List<String> addRegion(String regionName, String... placeNames) {
//		Region region = new Region(regionName);
//		for (String p : placeNames) {
//			if (!places.containsKey(p)){
//				Place place = new Place(p, region);
//				region.addPlace(place);
//				places.put(p, place);
//			}
//		}
//		List<String> regionPlaces = new ArrayList<>();
//		for (Place place : region.getPlaces()) {
//			regionPlaces.add(place.getName());
//		}
//
//		Collections.sort(regionPlaces);
//		return regionPlaces;
//	}


	public List<String> addCarrier(String carrierName, String... regionNames) {
		Carrier carrier = new Carrier(carrierName, regionNames);
		carriers.add(carrier);

		List<String> carrierRegionList = new ArrayList<>();

		for (String regionName : regionNames) {
			if (!carrierRegionList.contains(regionName)) {
				carrierRegionList.add(regionName);
			}
		}
		Collections.sort(carrierRegionList);
		return carrierRegionList;
	}

	public List<String> getCarriersForRegion(String regionName) {

		List<String> carrierList = new ArrayList<>();
		for (Carrier carrier : carriers) {
			carrierList.add(carrier.getCarrierName());
		}
		Collections.sort(carrierList);
		return carrierList;
	}

	//R2
	public void addRequest(String requestId, String placeName, String productId)
			throws TMException {
		if(!places.containsKey(placeName)) throw new TMException();
		if(requests.containsKey(requestId)) throw new TMException();
		Place place = places.get(placeName);

		Request request = new Request(requestId, place, productId);
		requests.put(requestId, request);

	}

	public void addOffer(String offerId, String placeName, String productId)
			throws TMException {
		if(!places.containsKey(placeName)) throw new TMException();
		if(offers.containsKey(offerId)) throw new TMException();

		Place place = places.get(placeName);

		Offer offer = new Offer(offerId, place, productId);
		offers.put(offerId, offer);
	}


	//R3
	public void addTransaction(String transactionId, String carrierName, String requestId, String offerId)
			throws TMException {

	}

	public boolean evaluateTransaction(String transactionId, int score) {

		return false;
	}

	//R4
	public SortedMap<Long, List<String>> deliveryRegionsPerNT() {
		Map<String, Long> regions = transactions.values().stream()
				.map(t->t.getRequestId().getClass())
				.collect(Collectors.groupingBy(r->r.getName(), Collectors.counting()));

		return regions.entrySet().stream().collect(Collectors.groupingBy(e->e.getValue(),
				()->new TreeMap<Long,List<String>>(Comparator.reverseOrder()),
				Collectors.mapping(e->e.getKey(), Collectors.toList())));
	}

	public SortedMap<String, Integer> scorePerCarrier(int minimumScore) {
		return transactions.values().stream()
				.filter(t->t.getScore() >= minimumScore)
				.collect(Collectors.groupingBy(t->t.getCarrierName(),
						TreeMap::new, Collectors.summingInt(t->t.getScore())));
	}
	public TreeMap<byte[], Long> nTPerProduct() {
		return transactions.values()
				.stream()
				.collect(Collectors.groupingBy(t->t.getRequestId().getBytes(),TreeMap::new,Collectors.counting()));
	}
}

