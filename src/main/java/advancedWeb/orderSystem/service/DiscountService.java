package advancedWeb.orderSystem.service;

import advancedWeb.orderSystem.domain.Discount;
import advancedWeb.orderSystem.dto.DiscountDTO;
import advancedWeb.orderSystem.repository.DiscountRepository;
import advancedWeb.orderSystem.util.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DiscountService {

    private final DiscountRepository discountRepository;

    @Autowired
    public DiscountService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    public List<Discount> getAllDiscounts() {
        return discountRepository.findAll();
    }

    public Optional<Discount> getDiscountById(Long id) {
        Optional<Discount> findDiscount = discountRepository.findById(id);
        return findDiscount;
    }

    public void updateDiscount(DiscountDTO discountDTO) {
        Discount discount = EntityConverter.toDiscount(discountDTO);
        discountRepository.updateDiscount(discount);
    }

}
