package tornadoes.jsph.cmu.smartshopper.entities;

import java.util.ArrayList;

import tornadoes.jsph.cmu.smartshopper.beans.HistoryData;

public class ViewHistoryData {
    private final static int MAX_ENTRY = 10;
    private ArrayList<HistoryData> historyData = new ArrayList<HistoryData>(MAX_ENTRY);

    public ArrayList<HistoryData> getHistoryData() {
        return historyData;
    }

    public HistoryData getHistoryData(int recordNumber) {
        return historyData.get(recordNumber);
    }

    public void setHistoryData(ArrayList<HistoryData> historyData) {
        this.historyData = historyData;
    }

    public void setHistoryData(HistoryData historyData,int recordNumber) {
        this.historyData.add(recordNumber,historyData);
    }
}
