package com.demo01.demo.service;

import com.demo01.demo.entity.MilkTeaForExcel;
import com.demo01.demo.entity.Milktea;
import com.demo01.demo.mappers.MilkteaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MilkteaServiceImpl implements MilkteaService {
    @Autowired
    MilkteaMapper milkteaMapper;

    @Override
    public List<Milktea> recommend() {
//        随机选择8款奶茶向用户推荐
        Integer nums = 8;
        Integer start = 1;
        Integer end = countMilktea();
        //1.创建集合容器对象
        List list = new ArrayList();
        List ret = new ArrayList();
        //2.创建Random对象
        Random r = new Random();
        //循环将得到的随机数进行判断，如果随机数不存在于集合中，则将随机数放入集合中，如果存在，则将随机数丢弃不做操作，进行下一次循环，直到集合长度等于nums
        while (list.size() != nums) {
            Integer num = r.nextInt(end - start) + start;
            if (!list.contains(num)) {
                list.add(num);
            }
        }
        for (Object l : list) {
            NumberFormat formatter = NumberFormat.getNumberInstance();
            String s = formatter.format(Integer.parseInt(l.toString()));

//            System.out.println(s);
            ret.add(selectOneMilktea(s));
        }
        return ret;
    }

    @Override
    public Milktea selectOneMilktea(String id) {
        return milkteaMapper.selectMilkteaById(id);
    }

    @Override
    public List<Milktea> selectAllMilktea() {
        return milkteaMapper.selectAll();
    }

    @Override
    public List<MilkTeaForExcel> selectMilkTeaForExcel() {
        return milkteaMapper.getMilkTeaForExcel();
    }

    @Override
    public List<Milktea> selectByType(String type) {
        return milkteaMapper.selectByType(type);
    }

    @Override
    public Integer countMilktea() {
        return milkteaMapper.countMilktea();
    }

    @Override
    public Integer countType() {

        return milkteaMapper.countType();
    }

    @Override
    public Integer saveMilktea(Milktea milktea) {
        return milkteaMapper.insertMilktea(milktea);
    }
    @Override
    public Integer updateMilktea(Milktea milktea) {
        return milkteaMapper.updateMilktea(milktea);
    }
    @Override
    public Integer deleteMilktea(String milkteaId) {
        return milkteaMapper.deleteMilktea(milkteaId);
    }
}
