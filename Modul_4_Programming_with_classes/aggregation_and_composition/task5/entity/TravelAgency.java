package by.jonline.module_4.aggregation_and_composition.task5.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TravelAgency implements Serializable {

	private static final long serialVersionUID = -1610396714438984804L;

	private List<TravelVoucher> vouchers;

	public TravelAgency() {
		this.vouchers = new ArrayList<>();
	}

	public List<TravelVoucher> getVouchers() {
		return vouchers;
	}

	public void setVauchers(List<TravelVoucher> vouchers) {
		if (vouchers != null) {
			this.vouchers = vouchers;
		}
	}

	public void addVoucher(TravelVoucher voucher) {
		if (voucher != null) {
			vouchers.add(voucher);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vouchers == null) ? 0 : vouchers.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		TravelAgency other = (TravelAgency) obj;

		return Objects.equals(obj, other.vouchers);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName()).append(" [vouchers=").append(vouchers).append("]");
		return builder.toString();
	}
}