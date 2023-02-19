package transactions;


import java.util.*;

import java.util.stream.Collectors;

public class TransactionManager {
	private Map<String, Region> regions = new HashMap<>();
	private Map<String, Place> places = new HashMap<>();
	private Map<String, Carrier> carriers = new HashMap<>();
	private Map<String,Request> requests = new HashMap<>();
	private Map<String,Offer> offers = new HashMap<>();
	private Map<String,Transaction> transactions = new HashMap<>();


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

	public List<String> addCarrier(String carrierName, String... regionNames) {
		Carrier carrier = new Carrier(carrierName);
		for(String r: regionNames) {
			if(regions.containsKey(r)){
				Region region = regions.get(r);
				carrier.addSuppliedRegions(region);
				region.addCarrier(carrier);
			}
		}
		carriers.put(carrierName, carrier);

		return carrier.getRegions().stream().map(r->r.getName()).sorted().collect(Collectors.toList());
	}


	public List<String> getCarriersForRegion(String regionName) {
		List<String> carrierList = new ArrayList<>();
		HashMap<Object, Object> carrierStringMap = new HashMap<>();
		for (Object carrier : carrierStringMap.keySet()) {
			carrierList.add(String.valueOf(carrier.getClass()));

		}

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
//		Offer offer = new Offer(offerId, placeName, productId);
//		offerList.add(offer);
	}


	//R3
	public void addTransaction(String transactionId, String carrierName, String requestId, String offerId)
			throws TMException {
//		Transaction transaction = new Transaction(transactionId, carrierName, requestId, offerId);
//		transactionList.add(transaction);
	}


	public boolean evaluateTransaction(String transactionId, int score) {
	return false;
	}

	//R4
	public SortedMap<Long, List<String>> deliveryRegionsPerNT() {
		return new TreeMap<Long, List<String>>();
	}

	public SortedMap<String, Integer> scorePerCarrier(int minimumScore) {
		return new TreeMap<String, Integer>();
	}

	public SortedMap<String, Long> nTPerProduct() {
		return new TreeMap<String, Long>();
	}

}

