public class MainActivity extends ListActivity {
 
       public void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.list);                              
 
          ImageListAdapter adapter = new ImageListAdapter(this);
          setListAdapter(adapter);                                    
              
       }
}
