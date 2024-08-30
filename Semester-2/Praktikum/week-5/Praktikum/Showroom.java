public class Showroom {
    int[] acceleration;
    int[] top_power;

    Showroom(int[] acceleration, int[] top_power) {
        this.acceleration = acceleration;
        this.top_power = top_power;
    }

    int highest_acceleration() {
        if (acceleration.length == 1) {
            return acceleration[0];
        }
        return highest_acceleration(acceleration, 0, acceleration.length - 1);
    }

    int highest_acceleration(int[] data, int start, int end) {
        if (start == end) {
            return data[start];
        }

        int mid = (start + end) / 2;

        int left = highest_acceleration(data, start, mid);
        int right = highest_acceleration(data, mid + 1, end);

        if (left > right) {
            return left;
        } else {
            return right;
        }
    }

    int lowest_acceleration() {
        if (acceleration.length == 1) {
            return acceleration[0];
        }
        return lowest_acceleration(acceleration, 0, acceleration.length - 1);
    }

    int lowest_acceleration(int[] data, int start, int end) {
        if (start == end) {
            return data[start];
        }

        int mid = (start + end) / 2;

        int left = lowest_acceleration(data, start, mid);
        int right = lowest_acceleration(data, mid + 1, end);

        if (left > right) {
            return right;
        } else {
            return left;
        }
    }

    int mean_top_power() {
        int sum = 0;
        for (int i : top_power) {
            sum += i;
        }
        sum /= top_power.length;
        return sum;
    }
}