package by.jonline.module_4.aggregation_and_composition.task5.main;

import java.util.List;

import by.jonline.module_4.aggregation_and_composition.task5.entity.FoodType;
import by.jonline.module_4.aggregation_and_composition.task5.entity.TravelAgency;
import by.jonline.module_4.aggregation_and_composition.task5.entity.TravelVoucher;
import by.jonline.module_4.aggregation_and_composition.task5.entity.TypeOfTransport;
import by.jonline.module_4.aggregation_and_composition.task5.entity.TypeOfVoucher;
import by.jonline.module_4.aggregation_and_composition.task5.logic.TravelVoucherLogic;
import by.jonline.module_4.aggregation_and_composition.task5.view.TravelVoucherView;

/**
 * Туристические путевки. Сформировать набор предложений клиенту по выбору
 * туристической путевки различного типа (отдых, экскурсии, лечение, шопинг,
 * круиз и т. д.) для оптимального выбора. Учитывать возможность выбора
 * транспорта, питания и числа дней. Реализовать выбор и сортировку путевок.
 */

public class Main {

	public static void main(String[] args) {

		TravelAgency agency = new TravelAgency();
		TravelVoucherLogic logic = new TravelVoucherLogic();
		TravelVoucherView view = new TravelVoucherView();

		agency.addVoucher(new TravelVoucher(TypeOfVoucher.TREATMENT, FoodType.RO, TypeOfTransport.TRAIN, 12));
		agency.addVoucher(new TravelVoucher(TypeOfVoucher.TREATMENT, FoodType.BB, TypeOfTransport.BUS, 14));
		agency.addVoucher(new TravelVoucher(TypeOfVoucher.CRUISE, FoodType.UAI, TypeOfTransport.LINER, 7));
		agency.addVoucher(new TravelVoucher(TypeOfVoucher.EXCURSION, FoodType.HB, TypeOfTransport.BUS, 5));
		agency.addVoucher(new TravelVoucher(TypeOfVoucher.RELAXATION, FoodType.AI, TypeOfTransport.AIRPLANE, 10));
		agency.addVoucher(new TravelVoucher(TypeOfVoucher.SHOPPING, FoodType.FB, TypeOfTransport.BUS, 4));

		for (TravelVoucher voucher : agency.getVouchers()) {
			voucher.setPrice(logic.calculatePrice(voucher));
		}

		List<TravelVoucher> vouchers;
		TravelVoucher request = new TravelVoucher();
		request.setTypeOfVaucher(TypeOfVoucher.CRUISE);
		request.setFoodType(FoodType.NOT_SET);
		request.setDays(9);

		vouchers = logic.findVoucher(agency.getVouchers(), request);

		if (!vouchers.isEmpty()) {
			view.printVouchers("Найденные путевки:", vouchers);
		} else {
			view.printErrorMessage("Путевки с такими параметрами не найдены.");
		}
	}
}