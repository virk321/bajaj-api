package com.example.demo.service;

import com.example.demo.dto.*;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BFHLServiceImpl implements BFHLService {

    @Override
    public ResponseDTO processData(RequestDTO request) {

        List<String> even = new ArrayList<>();
        List<String> odd = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> special = new ArrayList<>();

        StringBuilder allChars = new StringBuilder();

        long sum = 0;

        for(String item : request.getData()) {

            if(item.matches("\\d+")) {

                long num = Long.parseLong(item);

                sum += num;

                if(num % 2 == 0)
                    even.add(item);
                else
                    odd.add(item);

            } else if(item.matches("[a-zA-Z]+")) {

                alphabets.add(item.toUpperCase());

                allChars.append(item);

            } else {

                special.add(item);
            }
        }

        String concat = alternatingCaps(
                allChars.reverse().toString()
        );

        ResponseDTO response = new ResponseDTO();

        response.setIs_success(true);

        response.setUser_id("manjot_kaur_01102004");
        response.setEmail("virkmanjot68@gmail.com");
        response.setRoll_number("2310991338");

        response.setOdd_numbers(odd);
        response.setEven_numbers(even);
        response.setAlphabets(alphabets);
        response.setSpecial_characters(special);

        response.setSum(String.valueOf(sum));
        response.setConcat_string(concat);

        return response;
    }

    private String alternatingCaps(String str) {

        StringBuilder ans = new StringBuilder();

        for(int i=0;i<str.length();i++) {

            char ch = str.charAt(i);

            if(i%2==0)
                ans.append(Character.toUpperCase(ch));
            else
                ans.append(Character.toLowerCase(ch));
        }

        return ans.toString();
    }
}