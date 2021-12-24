package inner.classes;

public class Button {
    private String title;
    private OnCLickListener onClickListener;
    
    public Button(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
    public void setOnClickListener(OnCLickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
    public void onClick(){
        this.onClickListener.onClick(this.title);
    }
   
    
    public interface OnCLickListener {
        public void onClick(String title);
    }
    
    
}
