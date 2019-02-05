package job4j.carStrorage.logic.interfaces;

import job4j.carStrorage.logic.items.Ad;

import java.util.List;

public interface StorageAd {
    boolean add(Ad ad);
    boolean update(Ad ad);
    boolean remove(int id);
    List<Ad> returnAll();
    Ad returnById(int id);
}
