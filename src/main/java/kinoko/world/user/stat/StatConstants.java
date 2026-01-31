package kinoko.world.user.stat;

import kinoko.world.job.Job;
import kinoko.world.job.JobConstants;

public final class StatConstants {
    public static final int INC_HP_VARIANCE = 4;
    public static final int INC_MP_VARIANCE = 2; // 4 for pirates?

    public static boolean isAbilityUpStat(Stat stat) {
        return stat == Stat.MHP || stat == Stat.MMP || stat == Stat.STR || stat == Stat.DEX || stat == Stat.INT || stat == Stat.LUK;
    }

    public static int getIncAp(int level, int jobId) {
        if (level <= 70 && JobConstants.isCygnusJob(jobId)) {
            return 6;
        }
        return 5;
    }

    public static int getIncHp(int jobId) {
        // Probably inaccurate as we are just using minHp multiplier
        if (JobConstants.isBeginnerJob(jobId)) {
            return 12;
        }
        switch (JobConstants.getJobCategory(jobId)) {
            case 1 -> {
                return 24;
            }
            case 2 -> {
                return 10;
            }
            case 3, 4 -> {
                return 20;
            }
            case 5 -> {
                return 22;
            }
            default -> {
                return 0;
            }
        }
    }

    public static int getIncMp(int jobId) {
        // Probably inaccurate as we are just using minMp multiplier
        if (JobConstants.isBeginnerJob(jobId)) {
            return 10;
        }
        switch (JobConstants.getJobCategory(jobId)) {
            case 1 -> {
                return 4;
            }
            case 2 -> {
                return 22;
            }
            case 3, 4 -> {
                return 14;
            }
            case 5 -> {
                return 18;
            }
            default -> {
                return 0;
            }
        }
    }

    public static int getIncHpByAp(int jobId) {
        // IncHPVal
        switch (JobConstants.getJobCategory(jobId)) {
            case 0 -> {
                return 8;
            }
            case 1 -> {
                return 20;
            }
            case 3, 4 -> {
                return 16;
            }
            case 5 -> {
                return 18;
            }
            default -> {
                return 0;
            }
        }
    }

    public static int getIncMpByAp(int jobId) {
        // IncMPVal
        switch (JobConstants.getJobCategory(jobId)) {
            case 0 -> {
                return 6;
            }
            case 1 -> {
                return 2;
            }
            case 2 -> {
                return 18;
            }
            case 3, 4 -> {
                return 10;
            }
            case 5 -> {
                return 14;
            }
            default -> {
                return 0;
            }
        }
    }

    public static int getMinHp(int level, int jobId) {
        // CUIStatChange::IsUnderMinHP
        Job.getById(jobId);
        final int jobSuffix = jobId % 1000;
        switch (jobSuffix) {
            case 100, 120, 121, 122, 130, 131, 132 -> {
                return 24 * level + 118;
            }
            case 110, 111, 112 -> {
                return 24 * level + 418;
            }
            case 200, 210, 211, 212, 220, 221, 222, 230, 231, 232 -> {
                return 10 * level + 54;
            }
            case 300, 400 -> {
                return 20 * level + 58;
            }
            case 310, 311, 312, 320, 321, 322, 410, 411, 412, 420, 421, 422 -> {
                return 20 * level + 358;
            }
            case 430, 431, 432, 433, 434 -> {
                return 20 * level + 808;
            }
            case 500 -> {
                return 22 * level + 38;
            }
            case 510, 511, 512, 520, 521, 522 -> {
                return 22 * level + 338;
            }
            case 0, 1 -> {
                return 12 * level + 38;
            }
            default -> {
                return 0;
            }
        }
    }

    public static int getMinMp(int level, int jobId) {
        // CUIStatChange::IsUnderMinMP
        Job.getById(jobId);
        final int jobSuffix = jobId % 1000;
        switch (jobSuffix) {
            case 100, 110, 111, 112 -> {
                return 4 * level + 55;
            }
            case 120, 121, 122, 130, 131, 132 -> {
                return 4 * level + 155;
            }
            case 200 -> {
                return 22 * level - 1;
            }
            case 210, 211, 212, 220, 221, 222, 230, 231, 232 -> {
                return 22 * level + 449;
            }
            case 300, 400 -> {
                return 14 * level - 15;
            }
            case 310, 311, 312, 320, 321, 322, 410, 411, 412, 420, 421, 422 -> {
                return 14 * level + 135;
            }
            case 430, 431, 432, 433, 434 -> {
                return 14 * level + 355;
            }
            case 500 -> {
                return 18 * level - 55;
            }
            case 510, 511, 512, 520, 521, 522 -> {
                return 18 * level + 95;
            }
            case 0, 1 -> {
                return 10 * level - 5;
            }
            default -> {
                return 0;
            }
        }
    }

    public static int getSumAp(int level, int jobId) {
        // CUIStatChange::SetButtons
        int sumAp = 5 * (level + 4);
        if (JobConstants.isCygnusJob(jobId)) {
            sumAp = sumAp + Math.max(level, 70) - 1;
        }
        final int jobLevel = JobConstants.getJobLevel(jobId);
        if (jobLevel == 3) {
            sumAp += 5;
        } else if (jobLevel == 4) {
            sumAp += 10;
        }

        if (!JobConstants.isCygnusJob(jobId)) {
            int addAp = 1;
            if (jobLevel != 2) {
                addAp = jobLevel != 3 ? 0 : 2;
            }
            sumAp += addAp;
        }
        return sumAp;
    }
}
