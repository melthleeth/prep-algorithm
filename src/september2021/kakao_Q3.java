package september2021;

import java.io.*;
import java.util.*;

// 얘도 그냥 Map에 한번에 담아놓고 할걸
// 난 바보인가?

public class kakao_Q3 {

    public static void main(String[] args) throws IOException {
        int[] fees = new int[]{1, 461, 1, 10};
        String[] records = new String[]{"00:00 1234 IN"};

        // --------------------

        ArrayList<Car> cars = new ArrayList<>();
        Map<String, Integer> carCount = new TreeMap<>();
        Map<String, Integer> parkingInfo = new TreeMap<>();
        int LAST_TIME = timeToNumber("23:59");

        for (String record : records) {
            String[] info = record.split(" ");
            cars.add(new Car(info[1], timeToNumber(info[0]), info[2]));
            if (carCount.get(info[1]) == null) carCount.put(info[1], 1);
            else carCount.replace(info[1], carCount.get(info[1]) + 1);
        }

        cars.sort((o1, o2) -> {
            int carNum1 = Integer.parseInt("1" + o1.carNum);
            int carNum2 = Integer.parseInt("1" + o2.carNum);
            if (carNum1 == carNum2)
                return Integer.compare(o1.time, o2.time);
            return Integer.compare(carNum1, carNum2);
        });

        int[] answer = new int[carCount.keySet().size()];
        int idx = 0;
        int start = 0;
        for (String carNum : carCount.keySet()) {
            int cnt = carCount.get(carNum);
            int accumulatedParkingTime = 0;

            if ((cnt & 1) == 1) accumulatedParkingTime = LAST_TIME;

            for (int i = start; i < start + cnt; i++) {
                Car car = cars.get(i);
                if (car.status.equals("IN")) accumulatedParkingTime -= car.time;
                else accumulatedParkingTime += car.time;
            }
            System.out.println("accumulatedParkingTime: " + accumulatedParkingTime);
            answer[idx++] = calculateParkingFee(accumulatedParkingTime, fees);
            start += cnt;
        }

        System.out.println(Arrays.toString(answer));
    }

    public static int calculateParkingFee(int time, int[] fee) {
        if (time <= fee[0]) return fee[1];
        else {
            int exceededTime = time - fee[0];
            return fee[1] + (int)Math.ceil((double)exceededTime / fee[2]) * fee[3];
        }
    }

    public static int timeToNumber(String time) {
        String[] info = time.split(":");
        return Integer.parseInt(info[0]) * 60 + Integer.parseInt(info[1]);
    }

    static class Car {
        String carNum;
        int time;
        String status;

        public Car(String carNum, int time, String status) {
            this.carNum = carNum;
            this.time = time;
            this.status = status;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "carNum=" + carNum +
                    ", time=" + time +
                    ", status='" + status + '\'' +
                    '}';
        }
    }
}
