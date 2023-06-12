package advancedWeb.orderSystem.service;

import advancedWeb.orderSystem.domain.Discount;
import advancedWeb.orderSystem.dto.DiscountDTO;
import advancedWeb.orderSystem.repository.DiscountRepository;
import advancedWeb.orderSystem.util.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DiscountService {

    private final DiscountRepository discountRepository;

    @Autowired
    public DiscountService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    @Transactional
    public void updateDiscount(DiscountDTO discountDTO) {
        Discount discount = EntityConverter.toDiscount(discountDTO);
        discountRepository.updateDiscount(discount);
    }

}
