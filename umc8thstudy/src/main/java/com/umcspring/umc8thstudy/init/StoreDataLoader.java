//package com.umcspring.umc8thstudy.init;
//
//import com.umcspring.umc8thstudy.domain.Region;
//import com.umcspring.umc8thstudy.domain.Store;
//import com.umcspring.umc8thstudy.repository.RegionRepository;
//import com.umcspring.umc8thstudy.repository.StoreRepository.StoreRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//@Component
//@RequiredArgsConstructor
//public class StoreDataLoader implements CommandLineRunner {
//
//    private final StoreRepository storeRepository;
//    private final RegionRepository regionRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        if (storeRepository.count() == 0) {
//
//            Region seoul = regionRepository.save(new Region(1L, "서울", null));
//            Region busan = regionRepository.save(new Region(2L, "부산", null));
//            Region daejeon = regionRepository.save(new Region(3L, "대전", null));
//
//            Store store1 = Store.builder()
//                    .name("서울상점")
//                    .score(4.5f)
//                    .latitude(new BigDecimal("37.5665"))
//                    .longitude(new BigDecimal("126.9780"))
//                    .region(seoul)
//                    .build();
//
//            Store store2 = Store.builder()
//                    .name("부산상점")
//                    .score(4.2f)
//                    .latitude(new BigDecimal("35.1796"))
//                    .longitude(new BigDecimal("129.0756"))
//                    .region(busan)
//                    .build();
//
//            Store store3 = Store.builder()
//                    .name("대전상점")
//                    .score(4.8f)
//                    .latitude(new BigDecimal("36.3504"))
//                    .longitude(new BigDecimal("127.3845"))
//                    .region(daejeon)
//                    .build();
//
//            storeRepository.saveAll(List.of(store1, store2, store3));
//        }
//    }
//}