package com.zipcodewilmington.froilansfarm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TuesdayTest {

    List<CropRow<Crop>> listCrop = new ArrayList<>();

    @Test
    public void tuesdayHarvestTest () {
        CropRow<Crop> cropRow = new CropRow<>();
        CropRow<Crop> cropRow1 = new CropRow<>();
        CropRow<Crop> cropRow2 = new CropRow<>();
        TomatoPlant tomatoPlant = new TomatoPlant();
        CornStalk cornStalk = new CornStalk();

        Froilan.getFroilan().plant(cornStalk, cropRow);
        Froilan.getFroilan().plant(tomatoPlant, cropRow1);
        Froilan.getFroilan().plant(cornStalk, cropRow2);

        listCrop.add(cropRow);
        listCrop.add(cropRow1);
        listCrop.add(cropRow2);

        Tractor<Froilan> frolianTractor = new Tractor<>(Froilan.getFroilan());
        Froilan.getFroilan().mount(frolianTractor);

        for (CropRow<Crop> crop : listCrop) {
            frolianTractor.operate(crop);
        }
        Froilan.getFroilan().dismount(frolianTractor);
    }
}
