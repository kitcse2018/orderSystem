package advancedWeb.orderSystem.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public enum OrderStatus {
    ORDER, DELIVERY, COMPLETE, CANCEL
}
