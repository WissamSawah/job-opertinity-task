
import axios from 'axios';

// Fetch from FAKE backend 

class  PlaceholderData{
	static getData(){

		return new Promise((resolve,reject) => {
			try {

				axios.get('https://jsonplaceholder.typicode.com/users/'    ,{
					headers: {
						'Content-Type': 'application/json'
					}}).then((response) => {
                
					resolve(response.data);
                
				});

			} catch (err){
				reject(err);


			}
		});


    }
}

export default PlaceholderData; 