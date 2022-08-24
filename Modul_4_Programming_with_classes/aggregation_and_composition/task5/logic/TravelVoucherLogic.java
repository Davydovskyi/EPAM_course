package by.jonline.module_4.aggregation_and_composition.task5.logic;

import java.util.ArrayList;
import java.util.List;

import by.jonline.module_4.aggregation_and_composition.task5.entity.FoodType;
import by.jonline.module_4.aggregation_and_composition.task5.entity.TravelVoucher;
import by.jonline.module_4.aggregation_and_composition.task5.entity.TypeOfTransport;
import by.jonline.module_4.aggregation_and_composition.task5.entity.TypeOfVoucher;

public class TravelVoucherLogic {

	private List<TravelVoucher> findVoucher(List<TravelVoucher> vouchers, TypeOfVoucher typeOfVoucher) {
		List<TravelVoucher> foundVouchers = new ArrayList<>();

		if (typeOfVoucher == TypeOfVoucher.NOT_SET) {
			return vouchers;
		}

		for (TravelVoucher travelVoucher : vouchers) {
			if (travelVoucher.getTypeOfVoucher() == typeOfVoucher) {
				foundVouchers.add(travelVoucher);
			}
		}
		return foundVouchers;
	}

	public List<TravelVoucher> findVoucher(List<TravelVoucher> vouchers, TravelVoucher request) {
		List<TravelVoucher> foundVouchers;

		foundVouchers = findVoucher(vouchers, request.getTypeOfVoucher());
		foundVouchers = findVoucher(foundVouchers, request.getFoodType());
		foundVouchers = findVoucher(foundVouchers, request.getTransport());
		foundVouchers = findVoucher(foundVouchers, request.getDays());

		return foundVouchers;
	}

	private List<TravelVoucher> findVoucher(List<TravelVoucher> vouchers, FoodType foodType) {
		List<TravelVoucher> foundVouchers = new ArrayList<>();

		if (foodType == FoodType.NOT_SET) {
			return vouchers;
		}

		for (TravelVoucher travelVoucher : vouchers) {
			if (travelVoucher.getFoodType() == foodType) {
				foundVouchers.add(travelVoucher);
			}
		}
		return foundVouchers;
	}

	private List<TravelVoucher> findVoucher(List<TravelVoucher> vouchers, TypeOfTransport typeOfTransport) {
		List<TravelVoucher> foundVouchers = new ArrayList<>();

		if (typeOfTransport == TypeOfTransport.WITHOUT_TRANSPORT) {
			return vouchers;
		}

		for (TravelVoucher travelVoucher : vouchers) {
			if (travelVoucher.getTransport() == typeOfTransport) {
				foundVouchers.add(travelVoucher);
			}
		}
		return foundVouchers;
	}

	private List<TravelVoucher> findVoucher(List<TravelVoucher> vouchers, int days) {
		List<TravelVoucher> foundVouchers = new ArrayList<>();

		if (days == 0) {
			return vouchers;
		}

		for (TravelVoucher travelVoucher : vouchers) {
			if (travelVoucher.getDays() <= days) {
				foundVouchers.add(travelVoucher);
			}
		}
		return foundVouchers;
	}

	public int calculatePrice(TravelVoucher voucher) {

		final int PRICE_PER_DAY = 5;

		int totalPrice = 0;

		TypeOfVoucher type = voucher.getTypeOfVoucher();

		if (voucher.getDays() < 1 || type == TypeOfVoucher.NOT_SET) {
			return totalPrice;
		}

		totalPrice = voucher.getDays() * PRICE_PER_DAY;

		if (type == TypeOfVoucher.RELAXATION || type == TypeOfVoucher.TREATMENT) {
			totalPrice *= 2;
		} else if (type == TypeOfVoucher.CRUISE) {
			totalPrice *= 3;
		}

		FoodType food = voucher.getFoodType();
		if (food == FoodType.BB) {
			totalPrice += voucher.getDays();
		} else if (food == FoodType.HB) {
			totalPrice += voucher.getDays() * 2;
		} else if (food == FoodType.FB) {
			totalPrice += voucher.getDays() * 3;
		} else if (food == FoodType.AI) {
			totalPrice += voucher.getDays() * 4;
		} else if (food == FoodType.UAI) {
			totalPrice += voucher.getDays() * 5;
		}

		TypeOfTransport transport = voucher.getTransport();
		if (transport == TypeOfTransport.TRAIN) {
			totalPrice += 10;
		} else if (transport == TypeOfTransport.BUS) {
			totalPrice += 20;
		} else if (transport == TypeOfTransport.AIRPLANE) {
			totalPrice += 30;
		} else if (transport == TypeOfTransport.LINER) {
			totalPrice += 40;
		}
		return totalPrice;
	}
}