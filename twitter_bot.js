

var twit = require('twit');//import twit
var T = new twit({
	  consumer_key: '425lDAMsc5mo2qpJs8ESfs34x'
	,  consumer_secret: 'oznsyK1JREciIO26MHh2e9oUZ1rp0JbN1RV9EAXxoNRIjCNysC'
	,  access_token: '1064270153645506560-S0A4i8ZmQNcB6JOp0nz6lBEHGcz0jB'
	,  access_token_secret: 'H9B0LGzoIJVJkF4wBt3aXGQc2ZqM3xEf0cbV2EHPCxwEL'
})

/*
//get tweets
/////////////////////////////////////////////////////////////////
var params = {
	q: 'bow down',	//any tweets with LiftingPal since 2108-11-15  #LiftingPal since: 2018-11-15
	count: 10							//we want 10 of these tweets
};

function gotData(err, data, response) {
	var tweetids = data.statuses;
	for(var i = 0; i < tweetids.length; i++){
		console.log(tweetids[i].id);
		list[i] = tweetids[i].id;
	}
}

T.get('search/tweets', params, gotData)



//post tweets
//////////////////////////////////////////////////////////////////////

var tweet = {
	status: 'hello world'
}

function tweeted(err, data, response){
	if(err){
		console.log("Error");
	} else {
		console.log(data);
	}
}

T.post('statuses/update', tweet, tweeted)
*/
//stream
////////////////////////////////////////////////////////////////////

var phrase = '#LiftingPal';
var regex = /#LiftingPal/;

var stream = T.stream('statuses/filter', { track: phrase })
stream.on('tweet', gotTweet);


function gotTweet(tweet) {
  if (regex.test(tweet.text)) {

    console.log('Attempting to retweet ' + tweet.id_str + ": " + tweet.text);
    T.post('statuses/retweet', { id: tweet.id_str }, retweeted);

    // I could also favorite (i.e. "like")
    // T.post('favorites/create', { id: tweet.id_str }, retweeted);

    function retweeted(err, data, response) {
      if (err) {
        console.log("Error: " + err.message);
      } else {
        console.log('Retweeted: ' + tweet.id);
      }
    }

  }
}