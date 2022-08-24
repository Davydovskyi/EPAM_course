package by.jonline.module_4.aggregation_and_composition.task5.view;

import java.util.List;

import by.jonline.module_4.aggregation_and_composition.task5.entity.TravelVoucher;

public class TravelVoucherView {

	public void printVouchers(String message, List<TravelVoucher> vouchers) {
		System.out.println(message);

		System.out.println("------------------------------------");

		for (TravelVoucher travelVoucher : vouchers) {
			System.out.printf("Тип путевки: %s%nТранспорт: %s%nПитание: %s%nКоличество дней: %d%nСтоимость: %d%n",
					travelVoucher.getTypeOfVoucher().getName(), travelVoucher.getTransport().getName(),
					travelVoucher.getFoodType().getName(), travelVoucher.getDays(), travelVoucher.getPrice());

			System.out.println("------------------------------------");
		}
	}

	public void printErrorMessage(String message) {
		System.out.println(message);
	}
}