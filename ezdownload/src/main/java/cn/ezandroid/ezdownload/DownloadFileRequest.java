package cn.ezandroid.ezdownload;

import java.io.Serializable;

/**
 * DownloadFileRequest
 *
 * @author like
 * @date 2018-09-03
 */
public class DownloadFileRequest implements Serializable {

    private static final long serialVersionUID = 42L;

    private final static int MAX_RETRY_NUM = 3;

    public enum TaskStatus {
        WAITING,
        READY,
        DOWNLOADING,
        CANCELED,
        FAILED,
        COMPLETED
    }

    private long mTotalContentLength;
    private long mBlockSize;
    private int mBlockPosition;

    private long mStartPosition;
    private long mEndPosition;

    private float mProgress = 0;
    private int mRetryCount = 0;
    private TaskStatus mStatus = TaskStatus.WAITING;

    private String mUrl;
    private String mPath;

    public DownloadFileRequest(String url, String path, long totalContentLength, long blockSize, int blockPosition) {
        this.mUrl = url;
        this.mPath = path;

        this.mTotalContentLength = totalContentLength;
        this.mBlockSize = blockSize;
        this.mBlockPosition = blockPosition;

        this.mStartPosition = blockSize * blockPosition;
        this.mEndPosition = blockSize * blockPosition + blockSize;
    }

    public void addRetryCount() {
        if (mRetryCount < MAX_RETRY_NUM) {
            mRetryCount++;
        }
    }

    public boolean shouldRetry() {
        return mRetryCount < MAX_RETRY_NUM ? true : false;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        this.mUrl = url;
    }

    public String getPath() {
        return mPath;
    }

    public void setPath(String path) {
        this.mPath = path;
    }

    public long getTotalContentLength() {
        return mTotalContentLength;
    }

    public void setTotalContentLength(long totalContentLength) {
        this.mTotalContentLength = totalContentLength;
    }

    public long getBlockSize() {
        return mBlockSize;
    }

    public void setBlockSize(long blockSize) {
        this.mBlockSize = blockSize;
    }

    public int getBlockPosition() {
        return mBlockPosition;
    }

    public void setBlockPosition(int blockPosition) {
        this.mBlockPosition = blockPosition;
    }

    public long getStartPosition() {
        return mStartPosition;
    }

    public void setStartPosition(long startPosition) {
        this.mStartPosition = startPosition;
    }

    public long getEndPosition() {
        return mEndPosition;
    }

    public void setEndPosition(long endPosition) {
        this.mEndPosition = endPosition;
    }

    public float getProgress() {
        return mProgress;
    }

    public void setProgress(float progress) {
        this.mProgress = progress;
    }

    public TaskStatus getStatus() {
        return mStatus;
    }

    public void setStatus(TaskStatus status) {
        this.mStatus = status;
    }
}