TH-ProgressButton
============
Circular progress View button inspired by [FFCircularProgressView](https://github.com/elbryan/FFCircularProgressView)

![alt text](https://raw.github.com/Vyshakh-K/TH-ProgressButton/master/screenshots/progressshot1.png "Start state")

![alt text](https://raw.github.com/Vyshakh-K/TH-ProgressButton/master/screenshots/progressshot2.png "Running state")

![alt text](https://raw.github.com/Vyshakh-K/TH-ProgressButton/master/screenshots/progressshot3.png "Progress state")

![alt text](https://raw.github.com/Vyshakh-K/TH-ProgressButton/master/screenshots/progressshot4.png "End state")

![alt text](https://raw.github.com/Vyshakh-K/TH-ProgressButton/master/ProgressButton.gif "Progress Button")

##How to use:
1. Deployment target should be Api level 13 or above.

2. Add `com.thbs.progressbutton.MasterLayout.java` and `com.thbs.progressbutton.CusImage.java` to your project.
  
  
3. ##Layout:
                       
        <com.thbs.progressbutton.MasterLayout
            android:id="@+id/MasterLayout01"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerHorizontal="true"
            android:layout_centerVertical="true"
            android:clickable="true" >
        </com.thbs.progressbutton.MasterLayout>
 



4. ##Activity
                       
        static MasterLayout masterLayout;   //Should be static
        
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            
            masterLayout = (MasterLayout) findViewById(R.id.MasterLayout01);
            
            //Onclick listener of the progress button
    	    masterLayout.setOnClickListener(new OnClickListener() {
    		
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				masterLayout.animation();   //Need to call this method for animation and progression
                
				switch (masterLayout.flg_frmwrk_mode) {
                
				case 1:
						//Start state. Call your method
						break;
				case 2:
					
						//Running state. Call your method
						break;
					
				case 3:
					
					    //End state. Call your method
						break;
				}	
			}
		});
    }
            




5. ##Updating the progress
 
    
	Send the progress to MasterLayout's "cusview.setupprogress()" method from AsyncTask's "onProgressUpdate()".
   
         @Override
	 	protected void onProgressUpdate(Integer... progress) 
	 	{

			//publishing progress to progress arc
			masterLayout.cusview.setupprogress(progress[0]);
 
	 	}





6. ##Customization
    
    - Basic customization can be done in "com.thbs.progressbutton.MasterLayout.java".
        
        Circle related customization:
        
                stroke_color.setColor(Color.rgb(0, 161, 234));  // Edit this to change the circle color

                fill_color.setColor(Color.rgb(0, 161, 234));   // Edit this to change the circle fill color
           
           
        Icon related customization:
        
                icon_color.setStyle(Paint.Style.FILL_AND_STROKE);  // Edit this to change the icon color
           
           
                final_icon_color.setColor(Color.WHITE);   // Edit this to change the final icon color
           
    
    
    Create new icons using path or use the existing icons in method "iconCreate()"
        
        

    - Progress arc color can be changed from "com.thbs.progressbutton.CusImage.java" using:
        
        
        
        myPaint.setColor(Color.rgb(0, 161, 234));    
 
 
##Are you using this framework?

- If you are using this widget please feel free to add your app to the [wiki](https://github.com/torryharris/TH-ProgressButton/wiki/Apps).
    

##Demo
Please download and run the [project](https://github.com/torryharris/TH-ProgressButton) to view demo.

##License
ProgressButton is licensed under the terms of the MIT License. Please see the [License](https://github.com/torryharris/TH-ProgressButton/blob/master/LICENSE) file for full details.
