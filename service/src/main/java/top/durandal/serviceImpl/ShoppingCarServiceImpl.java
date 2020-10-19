package top.durandal.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import top.durandal.api.service.ShoppingCarService;
import top.durandal.dao.GoodsDao;
import top.durandal.dao.ShoppingCarDao;
import top.durandal.entity.ShoppingCar;

import javax.annotation.Resource;
import java.util.List;

@Service
@Component
public class ShoppingCarServiceImpl implements ShoppingCarService {

    @Resource
    ShoppingCarDao shoppingCarDao;
    @Resource
    GoodsDao goodsDao;

    public ShoppingCar queryById(Integer shoppingCarId) {
        ShoppingCar queryById = shoppingCarDao.queryById(shoppingCarId);
        return queryById;
    }

    public List<ShoppingCar> queryAllByLimit(int offset, int limit) {
        return null;
    }

    public ShoppingCar insert(ShoppingCar shoppingCar) {
        shoppingCarDao.insert(shoppingCar);
        shoppingCar.setGoods(goodsDao.queryById(shoppingCar.getGoodsId()));
        return shoppingCarDao.queryById(shoppingCar.getShoppingCarId());
    }

    public ShoppingCar update(ShoppingCar shoppingcar) {
        return null;
    }

    public boolean deleteById(Integer shoppingcarId) {
        return false;
    }

    public List<ShoppingCar> getAllCartByUserId(Integer userId) {
        List<ShoppingCar> allCartByUserId = shoppingCarDao.getAllCartByUserId(userId);
        if (allCartByUserId.size()!=0){
            return allCartByUserId;
        }
        return null;
    }
}
