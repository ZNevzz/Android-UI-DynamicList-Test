public class ImageListAdapter extends BaseAdapter {
 
       private Context mContext;
 
       private LayoutInflater mLayoutInflater;                              #1
 
       private ArrayList<Entry> mEntries = new ArrayList<Entry>();          #2
 
       private final ImageDownloader mImageDownloader;                      #3
 
       public ImageListAdapter(Context context) {                           #4
          mContext = context;
          mLayoutInflater = (LayoutInflater) mContext
                   .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          mImageDownloader = new ImageDownloader(context);
       }
 
       @Override
       public int getCount() {
          return mEntries.size();
       }
 
       @Override
       public Object getItem(int position) {
          return mEntries.get(position);
       }
 
       @Override
       public long getItemId(int position) {
          return position;
       }
 
       @Override
       public View getView(int position, View convertView,
             ViewGroup parent) {                                           
          RelativeLayout itemView;
          if (convertView == null) {                                      
             itemView = (RelativeLayout) mLayoutInflater.inflate(
                      R.layout.list_item, parent, false);
 
          } else {
             itemView = (RelativeLayout) convertView;
          }
 
          ImageView imageView = (ImageView)
             itemView.findViewById(R.id.listImage);                        
          TextView titleText = (TextView)
             itemView.findViewById(R.id.listTitle);                        
          TextView descriptionText = (TextView)
             itemView.findViewById(R.id.listDescription);                  
 
          String imageUrl = mEntries.get(position).getContent().getSrc(); 
          mImageDownloader.download(imageUrl, imageView);                 
 
          String title = mEntries.get(position).getTitle().get$t();
          titleText.setText(title);
          String description =
             mEntries.get(position).getSummary().get$t();
          if (description.trim().length() == 0) {
             description = "Sorry, no description for this image.";
          }
          descriptionText.setText(description);
 
          return itemView;
       }
 
       public void upDateEntries(ArrayList<Entry> entries) {
          mEntries = entries;
          notifyDataSetChanged();
       }
}