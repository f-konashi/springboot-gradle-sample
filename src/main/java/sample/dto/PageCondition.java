package sample.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * ページ情報保管用。
 *
 * @author NUMADATE, Akihisa
 */
public class PageCondition {

    /** 1ページ単位の表示件数。 */
    private int displayLimitCount;
    /** 選択されたページ番号。 */
    private int pageNo;
    /** 表示するデータの開始位置。 */
    private int startingPosition;
    /** 表示するデータの終了位置。 */
    private int endPosition;
    /** 検索結果の総件数。 */
    private int totalCount;
    /** 検索結果の総ページ数。 */
    private int totalPage;
    /** 画面下部の表示ページ数。 */
    private int displayLimitPageCount;
    /** ページリスト。 */
    private List<Integer> pageNumberList;

    /**
     * コンストラクタ。
     * 
     * @param displayLimitPageCount 1ページ単位の表示件数
     */
    public PageCondition(Integer displayLimitPageCount) {
        this.displayLimitPageCount = displayLimitPageCount;
        // 初期ページリスト作成
        pageNumberList = new ArrayList<Integer>();
        for (int i = 1; i <= displayLimitPageCount; i++) {
            pageNumberList.add(i);
        }
    }

    /**
     * @return displayLimitCount
     */
    public int getDisplayLimitCount() {
        return displayLimitCount;
    }

    /**
     * @param displayLimitCount セットする displayLimitCount
     */
    public void setDisplayLimitCount(int displayLimitCount) {
        this.displayLimitCount = displayLimitCount;
    }

    /**
     * @return pageNo
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * @param pageNo セットする pageNo
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * @return startingPosition
     */
    public int getStartingPosition() {
        return startingPosition;
    }

    /**
     * @param startingPosition セットする startingPosition
     */
    public void setStartingPosition(int startingPosition) {
        this.startingPosition = startingPosition;
    }

    /**
     * @return endPosition
     */
    public int getEndPosition() {
        return endPosition;
    }

    /**
     * @param endPosition セットする endPosition
     */
    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }

    /**
     * @return totalCount
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * @param totalCount セットする totalCount
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * @return totalPage
     */
    public int getTotalPage() {
        return totalPage;
    }

    /**
     * @param totalPage セットする totalPage
     */
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    /**
     * @return displayLimitPageCount
     */
    public int getDisplayLimitPageCount() {
        return displayLimitPageCount;
    }

    /**
     * @param displayLimitPageCount セットする displayLimitPageCount
     */
    public void setDisplayLimitPageCount(int displayLimitPageCount) {
        this.displayLimitPageCount = displayLimitPageCount;
    }

    /**
     * @return pageNumberList
     */
    public List<Integer> getPageNumberList() {
        return pageNumberList;
    }

    /**
     * @param pageNumberList セットする pageNumberList
     */
    public void setPageNumberList(List<Integer> pageNumberList) {
        this.pageNumberList = pageNumberList;
    }
    
    
}
