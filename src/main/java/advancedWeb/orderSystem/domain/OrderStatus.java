package advancedWeb.orderSystem.domain;

import javax.persistence.Embeddable;

@Embeddable
public enum OrderStatus {
    ORDER, DELIVERY, COMPLETE, CANCEL
}
