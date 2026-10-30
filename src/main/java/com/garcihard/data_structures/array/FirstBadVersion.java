package com.garcihard.data_structures.array;

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
public class FirstBadVersion {
    public int firstBadVersion(int n) {

        int left = 1, right = n, mid = 0;

        while ( left < right ) {
            mid = (left + right) / 2;

            if ( isBadVersion(mid) ) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        return left;
    }
}
