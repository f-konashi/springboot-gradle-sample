package sample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import sample.dto.PageCondition;

/**
 * ページング処理。
 * 
 * @author NUMADATE, Akihisa (SIOS Technology, Inc.) 
 */
@Service
public class PagerService {
    
    /** 画面表示件数。 */
    private int displayLimitCount;
    /** ページ表示件数。 */
    private int displayLimitPageCount;

//    /** application.ymlの定数アクセスクラス。 */
//    @Autowired
//    private AppConst applicationConst;
    
    /**
     * @return displayLimitCount
     */
    public int getDisplayLimitCount() {
        return displayLimitCount;
    }

    /**
     * @return displayLimitPageCount
     */
    public int getDisplayLimitPageCount() {
        return displayLimitPageCount;
    }

    /**
     * ページ情報を取得する。
     *
     * @param page 選択されたページ番号
     * @param paramTotalCount パラメータ総件数
     * @return ページ情報
     */
    public PageCondition getPageCondition(int page, Integer paramTotalCount) {
//        //   TODO DBまたは設定ファイルに定義する
//        displayLimitCount = Integer.parseInt(getServiceInfoSearchConst("displayLimitCount"));
//        //   TODO DBまたは設定ファイルに定義する
//        displayLimitPageCount = Integer.parseInt(getServiceInfoSearchConst("displayLimitPageCount"));
        
        //   TODO DBまたは設定ファイルに定義する
        displayLimitCount = 20;
        //   TODO DBまたは設定ファイルに定義する
        displayLimitPageCount = 10;

        // 開始位置の算出
        int startingPosition = calcStartingPosition(page, displayLimitCount);
        // 終了位置の算出
        int endPosition = calcEndPosition(startingPosition, paramTotalCount, displayLimitCount);
        // ページ数の算出
        int totalPage = calcTotalPage(paramTotalCount, displayLimitCount);

        // ページ情報設定
        PageCondition pageCondition = new PageCondition(getDisplayLimitPageCount());
        pageCondition.setTotalCount(paramTotalCount);
        pageCondition.setDisplayLimitCount(displayLimitCount);
        pageCondition.setPageNo(page);
        pageCondition.setStartingPosition(startingPosition);
        pageCondition.setEndPosition(endPosition);
        pageCondition.setTotalCount(paramTotalCount);
        pageCondition.setTotalPage(totalPage);
        pageCondition.setDisplayLimitPageCount(displayLimitPageCount);
        
        // ページ情報調整
        pageAdjustment(pageCondition);

        return pageCondition;
    }
    
    /**
     * ページ情報調整。
     * 
     * @param pageCondition ページ情報
     */
    private void pageAdjustment(PageCondition pageCondition) {
        int pageNo = pageCondition.getPageNo();
        int pageCount = pageCondition.getDisplayLimitPageCount();
        int totalPage = pageCondition.getTotalPage();
        
        if (totalPage < pageCount) {
            // 総ページ数がページ表示件数未満の場合
            List<Integer> pageNumberList = new ArrayList<Integer>();
            for (int i = 1; i <= totalPage; i++) {
                pageNumberList.add(i);
            }
            pageCondition.setPageNumberList(pageNumberList);
        } else if (pageNo > pageCount / 2) {
            // 最初に表示するページ番号を算出
            int startPageNumber = pageNo - pageCount / 2 + 1;
            // ページの表示数をページ表示件数分必ず表示させるために最初に表示するページ数を調整
            if (totalPage < startPageNumber + pageCount) {
                startPageNumber = totalPage - pageCount + 1;
            }

            // 表示するページ番号のリストを作成
            List<Integer> pageNumberList = new ArrayList<Integer>();
            for (int i = startPageNumber; i < startPageNumber + pageCount; i++) {
                pageNumberList.add(i);
            }
            pageCondition.setPageNumberList(pageNumberList);
        }
    }

    /**
     * 送られてきた情報をもとにページの開始位置を算出。
     *
     * @param page ページ数
     * @param limitCount 画面表示件数
     * @return 算出結果
     */
    private int calcStartingPosition(int page, int limitCount) {
        return (page - 1) * limitCount;
    }

    /**
     * 送られてきた情報をもとにページの終了位置を算出。
     * @param startingPosition ページの開始位置
     * @param totalCount 総件数
     * @param limitCount 画面表示件数
     * @return 算出結果
     */
    private int calcEndPosition(int startingPosition, int totalCount, int limitCount) {
        return startingPosition + limitCount > totalCount ? totalCount : startingPosition + limitCount;
    }

    /**
     * ページ数を算出。
     *
     * @param totalCount 総件数
     * @param limitCount 画面表示件数
     * @return ページ数
     */
    private int calcTotalPage(int totalCount, int limitCount) {
        if (totalCount == 0) {
            return 1;
        }
        int subtotal = (totalCount + limitCount) % limitCount;
        if (subtotal == 0) {
            return totalCount / limitCount;
        } else {
            return totalCount / limitCount + 1;
        }
    }
    
//    /**
//     * サービス情報検索の定数値を取得する。
//     * 
//     * @param key 取得対象のキー情報
//     * @return 定数値
//     */
//    private String getServiceInfoSearchConst(String key) {
//        return applicationConst.getConstValues(ApplicationYmlKeys.SERVICE_INFO_SEARCH).get(key);
//    }
}