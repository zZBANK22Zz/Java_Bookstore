package Homework.Lab4;

class Election {
    public int num_Candidates;
    public int totalVotes;
    public String[] name;
    public int[] votes;

    public void setNumCandidates(int num) {
        num_Candidates = num;
        name = new String[num];
        votes = new int[num];
    }

    public void addCandidate(int cindex, String cname, int cvotes) {
        name[cindex] = cname;
        votes[cindex] = cvotes;
    }

    //Ananthichai saehui 6530613030 DE.

    public int calcTotalVotes() {
        totalVotes = 0;
        for (int vote : votes) {
            totalVotes += vote;
        }
        return totalVotes;
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public int calculateWinner() {
        int maxVotes = Integer.MIN_VALUE;
        int winnerIndex = -1;
        for (int i = 0; i < num_Candidates; i++) {
            if (votes[i] > maxVotes) {
                maxVotes = votes[i];
                winnerIndex = i;
            }
        }
        return winnerIndex;
    }
}


