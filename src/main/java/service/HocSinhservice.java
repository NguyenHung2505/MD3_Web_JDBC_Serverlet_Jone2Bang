package service;

import model.HocSinh;

import java.util.List;

public interface HocSinhservice extends GenneralService <HocSinh>{
     List<HocSinh> findAllByClass(int classId);
     List<HocSinh> findAllByCNameContains(String name);
}
