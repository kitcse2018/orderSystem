package advancedWeb.orderSystem.domain;

import javax.persistence.Embeddable;

@Embeddable
public enum DeliveryStatus {
    ORDER, DELIVERY, COMPLETE, CANCEL
}
