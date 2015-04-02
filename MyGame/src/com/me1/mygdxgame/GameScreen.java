package com.me1.mygdxgame;

//THIS IS THE BODY OF THE PROJECT
//BASICALLY, THE OBSTACLES, BILL, AND SCREENS ARE THE ARMS AND LEGS

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class GameScreen implements Screen{
	
	Boolean Sound;

	MyGame game;
	
	OrthographicCamera camera;
	
	SpriteBatch batch;
	
	float stateTime;
	
	

	
	Random rand;
	
	boolean appeared;
	
	int holder;
	
	Vector3 touch;
	
	Bill bill;
	
	Obstacle obstacle;
	
	Obstacle2 obstacle2;
	
	Obstacle3 obstacle3;
	
	Obstacle4 obstacle4;
	
	Obstacle5 obstacle5;
	
	Obstacle6 obstacle6;
	
	Obstacle7 obstacle7;
	
	Obstacle8 obstacle8;
	
	Obstacle9 obstacle9;
	
	Obstacle10 obstacle10;
	
	GameOver gameover;
	
	GameOverButton tryagainbutton;
	
	CloudBackground cloudbackground;
	
	Powerup1 powerup1;
	
	Powerdown1 powerdown1;
	
	long startTime;
	
	long startTimePOWER;
	long startTimePOWERD;
	
	long startTimeWHOLEGAME;
	
	
	long estimatedTime;
	long estimatedTimePOWER;
	long estimatedTimePOWERD;
	
	long estimatedTimeWHOLEGAME;
	
	long timeHolder;
	long timeHolder2;

	boolean repeat;
	
	boolean startover1;
	boolean startover2;
	boolean startover3;
	boolean startover4;
	boolean startover5;
	boolean startover6;
	boolean startover7;
	boolean startover8;
	boolean startover9;
	boolean startover10;
	boolean startover11;
	boolean startover12;
	boolean recycleBackground;
	boolean isGameOver = false;
	
	
	boolean TryAgainButton = false;
	
	
	boolean POWEREDUP;
	
	boolean POWEREDDOWN;
	
	long eventTimer;
	long eventTimerPOWER;
	long eventTimerPOWERD;
	
	
	TitleScreen titlescreen;
	
	int obstacleType;
	
	int modifier;
	
	int timedifficulty;
	boolean flipSwitch;
	long timeHolder3;
	boolean StartButton = false;

	Button button;
	

	

	
	public GameScreen(MyGame game){
		this.game = game;
		
		rand = new Random();
		
		camera = new OrthographicCamera();
		
		camera.setToOrtho(true, 1920,1080);
		
		batch = new SpriteBatch();
		
		touch = new Vector3();
		
		stateTime = 0F;
		
		holder =0;
		
		bill = new Bill();
		
		obstacle = new Obstacle();
		
		obstacle2 = new Obstacle2();
		
		obstacle3 = new Obstacle3();
		
		obstacle4 = new Obstacle4();
		
		obstacle5 = new Obstacle5();
		
		obstacle6 = new Obstacle6();
		
		obstacle7 = new Obstacle7();
		
		obstacle8 = new Obstacle8();
		
		obstacle9 = new Obstacle9();
		
		obstacle10 = new Obstacle10();
		
		powerup1 = new Powerup1();
		
		powerdown1 = new Powerdown1();
		
		tryagainbutton = new GameOverButton();
		
		cloudbackground = new CloudBackground();
		
		gameover = new GameOver();
		
		startTime = System.nanoTime();
		
		startTimePOWER = System.nanoTime() ;
		startTimePOWERD = System.nanoTime();
		
		startTimeWHOLEGAME = System.nanoTime();
		
		timeHolder = 0;
		timeHolder2 = 0;
		
		
		startover1 = false;
		startover2 = false;
		startover3 = false;
		startover4 = false;
		startover5 = false;
		startover6 = false;
		startover7 = false;
		startover8 = false;
		startover9 = false;
		startover10 = false;
		startover11 = false;
		startover12 = false;
		
		
		POWEREDUP = false;
		
		POWEREDDOWN = false;
		
		eventTimer = 5;
		
		eventTimerPOWER = 5;
		
		
		titlescreen = new TitleScreen();
		
		obstacleType = 1; // doesnt matter what no. it is initially
		
		modifier = 0;
		
		timedifficulty = 0;
		
		flipSwitch = true;
		timeHolder3 = 0;
		
		button = new Button();
		titlescreen.counter = 1;
		
		recycleBackground = true;
		


		

		

		
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1F,1F,1F,1F);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		
		
		camera.update();
		generalUpdate(touch, camera);
		obstacleUpdate();
		obstacle2Update();
		obstacle3Update();
		obstacle4Update();
		obstacle5Update();
		obstacle6Update();
		powerup1Update();
		powerdown1Update();
		obstacle7Update();
		obstacle8Update();
		obstacle9Update();
		obstacle10Update();
		cloudBackgroundUpdate();
		CheckStartButton(touch, camera);
		
		if(isGameOver == true){
			
			CheckTryAgainButton(touch, camera);
		}
		
		//checkIfButtonTouched();
		
		stateTime += Gdx.graphics.getDeltaTime();
		
		Assets.current_frame = Assets.loading_animation.getKeyFrame(stateTime, true);
		
		batch.setProjectionMatrix(camera.combined);
		
		batch.begin();

		
		
		if (StartButton == false || TryAgainButton == true){
			TryAgainButton = false;
			isGameOver = false;
			batch.draw(titlescreen.image, titlescreen.bounds.x, titlescreen.bounds.y);
			batch.draw(button.image, button.bounds.x, button.bounds.y);
			Sound = true;
			//System.out.println("2button bounds x is "+ button.bounds.x);
			//System.out.println("2button bounds y is "+ button.bounds.y);
			
			
			

			
		//need to figure out how to take away titlescreen object!!
		}
		
		if (StartButton == true && isGameOver == false){
			
			
			if( recycleBackground == true){
				
				batch.draw(cloudbackground.image, 0, 0);
				
				Sound = true;
				
				cloudbackground.bounds.x = 0;

				recycleBackground = false;
				System.out.println("BACKGROUND IMAGE SPWNED RIGHT NOW");
				
			}
			else{
				batch.draw(cloudbackground.image, cloudbackground.bounds.x, cloudbackground.bounds.y);
				
			}
			

		
			batch.draw(Assets.current_frame, 0,0); // 0,0 is the coordinates it will spawn in
			
			batch.draw(bill.image, bill.bounds.x, bill.bounds.y);

			
			//if buttonTouched == Falese;
			     //draw.titlescreen
			     //draw.button
			
			

			
			estimatedTime = (System.nanoTime() - startTime)/1000000000;
			estimatedTimeWHOLEGAME = (System.nanoTime() - startTimeWHOLEGAME)/1000000000;

			//System.out.println("the estimatedTime is : "+ estimatedTime);
			
			
			

			
			if (POWEREDUP == true){
				modifier = -4;
				estimatedTimePOWER = (System.nanoTime() - startTimePOWER)/1000000000;
				System.out.println("THE ESTIMATEDTIMEpower IS = "+ estimatedTimePOWER);
				if(powerup1.holder == true){
					timeHolder = estimatedTimePOWER;
					powerup1.holder = false;

				}
			System.out.println("IS estimated time, "+estimatedTimePOWER+ ", greater than or equal to timeholder, "+timeHolder+" , NO.");
				
			if(  estimatedTimePOWER >= timeHolder + 7){

				modifier = 0;
				POWEREDUP = false;
				powerup1.holder = true;

				}
					
			}
			
			
			
			if (POWEREDDOWN == true){
				modifier =  + 4;
				estimatedTimePOWERD = (System.nanoTime() - startTimePOWER)/1000000000;
				System.out.println("THE ESTIMATEDTIMEpower IS = "+ estimatedTimePOWERD);
				if(powerdown1.holder == true){
					timeHolder2 = estimatedTimePOWERD;
					powerdown1.holder = false;

				}
			System.out.println("IS estimated time, "+estimatedTimePOWERD+ ", greater than or equal to timeholder, "+timeHolder2+"? , NO.");
				
			if(  estimatedTimePOWERD >= timeHolder2 + 7){

				modifier = 0;
				POWEREDDOWN = false;
				powerdown1.holder = true;

				}
					
			}
			
			////////////////////////////////////////////////////////////////
			
			System.out.println(" estimatedTimeWHOLEGAME is "+ estimatedTimeWHOLEGAME);
			System.out.println(" increased speed of obstacles is is "+ timedifficulty);
			
			
			
			if( (estimatedTimeWHOLEGAME/10) >= 1){
				timedifficulty += 3;
				timeHolder3 = estimatedTimeWHOLEGAME;
				flipSwitch = false;
				startTimeWHOLEGAME = System.nanoTime();
				System.out.println("TIMEDIFFICULTY IS NOW "+ timedifficulty);

				
			}
			
			if(flipSwitch == false){
				System.out.println("TIMEDIFFICULTY IS NOW "+ timedifficulty);
			}

			//////////////////////////////////////////////////////////////////
			
			

			


			
			if (titlescreen.counter == 1){
				
				obstacleType = rand.nextInt(12) +1; //ensures eventTimer is between  12  and 1
				System.out.println("the random event timer is "+eventTimer);
				titlescreen.counter++;
				startTime = System.nanoTime();
				eventTimer = rand.nextInt(3) + 1;
				System.out.println("the eventTimer  is "+eventTimer);
			}
			
			
			// RANDOMIZED OBSTACLE SPAWNING !!!!!!!!!!!!!!!!!!!!!!!!!!!!!//
			
			if ( estimatedTime >= eventTimer ){
				
				System.out.println(estimatedTime +" > "+ eventTimer+" ASDLKFJ;L");

				
				

				if (POWEREDDOWN == true){
					
					eventTimer = 1;
					
				}
				
				else if (POWEREDDOWN == false && POWEREDUP == false){
					
					eventTimer = rand.nextInt(2) + 1; //ensures eventTimer is between 1-3
				}
				
				else if (POWEREDUP == true){
					
					eventTimer = 2;
					
				}
				
				if( timedifficulty >12 ){
					eventTimer = 1;
				}
			

				System.out.println("obstacleType is " + obstacleType);
				
				
				
				
				
				if(obstacleType == 11){ 
					
					if((powerup1.counter ==0) || (startover7)){
					
						powerup1.bounds.y = rand.nextInt(952);
						powerup1.counter++;
						powerup1.bounds.x = 1920;
						System.out.println("pwu1 in place");
						startover7 = false;
						batch.draw(powerup1.image, powerup1.bounds.x, powerup1.bounds.y);
					
					}
					
					startTime = System.nanoTime();
				
				}
				
				if(obstacleType == 12){
					
					if ((powerdown1.counter ==0) || (startover8 == true) ){
						powerdown1.bounds.y = rand.nextInt(952);
						powerdown1.counter++;
						powerdown1.bounds.x = 1920;
						startover8 = false;
						System.out.println("pwd1 spawned");
						batch.draw(powerdown1.image, powerdown1.bounds.x, powerdown1.bounds.y);
					}
					
					startTime = System.nanoTime();
				
				}
					
				if(obstacleType >= 1 && obstacleType <= 5){
							

							
					if( (obstacle.counter ==0) || (startover1 == true) ){
						obstacle.bounds.y = rand.nextInt(952);
						obstacle.counter++;
						obstacle.bounds.x = 1920;
						startover1 = false;
						System.out.println("obs1 spawned");
						batch.draw(obstacle.image, obstacle.bounds.x, obstacle.bounds.y);
					}
							
					else if ( ((obstacle3.counter ==0) && (obstacle.counter > 0)) || (startover3 == true) ){
						obstacle3.bounds.y = rand.nextInt(952);
						obstacle3.counter++;
						obstacle3.bounds.x = 1920;
						System.out.println("obs3 in place");
						startover3 = false;
						batch.draw(obstacle3.image, obstacle3.bounds.x, obstacle3.bounds.y);
						}
						
					else if (((obstacle5.counter ==0) && (obstacle3.counter > 0)) || (startover5 == true) ){
						obstacle5.bounds.y = rand.nextInt(952);
						obstacle5.counter++;
						obstacle5.bounds.x = 1920;
						System.out.println("obs5 in place");
						startover5 = false;
						batch.draw(obstacle5.image, obstacle5.bounds.x, obstacle5.bounds.y);

					}
					
					else if ( ((obstacle8.counter ==0) && (obstacle5.counter > 0)) || (startover9 == true) ){
						obstacle8.bounds.y = rand.nextInt(952);
						obstacle8.counter++;
						obstacle8.bounds.x = 1920;
						System.out.println("obs8 in place");
						startover9 = false;
						batch.draw(obstacle8.image, obstacle8.bounds.x, obstacle8.bounds.y);
						}
					
					startTime = System.nanoTime();
				
				}
						
						
				if(obstacleType >= 6 && obstacleType <= 10){
					
					if ((obstacle2.counter ==0) || (startover2 == true) ){
						obstacle2.bounds.y = rand.nextInt(952);
						obstacle2.counter++;
						obstacle2.bounds.x = 1920;
						startover2 = false;
						System.out.println("obs2 spawned");
						batch.draw(obstacle2.image, obstacle2.bounds.x, obstacle2.bounds.y);

					}
						
					else if ( ((obstacle4.counter ==0) && (obstacle2.counter > 0)) || (startover4 == true) ){
						obstacle4.bounds.y = rand.nextInt(952);
						obstacle4.counter++;
						obstacle4.bounds.x = 1920;
						System.out.println("obs4 in place");
						startover4 = false;
						batch.draw(obstacle4.image, obstacle4.bounds.x, obstacle4.bounds.y);
						System.out.println("obstacle4 has spawned");
					}
						
					else if ( ((obstacle6.counter ==0) && (obstacle4.counter > 0)) || (startover6 == true) ){
						obstacle6.bounds.y = rand.nextInt(952);
						obstacle6.counter++;
						obstacle6.bounds.x = 1920;
						System.out.println("obs6 in place");
						startover6 = false;
						batch.draw(obstacle6.image, obstacle6.bounds.x, obstacle6.bounds.y);
						}
					
					else if ( ((obstacle9.counter ==0) && (obstacle6.counter > 0)) || (startover10 == true) ){
						obstacle9.bounds.y = rand.nextInt(952);
						obstacle9.counter++;
						obstacle9.bounds.x = 1920;
						System.out.println("obs9 in place");
						startover10 = false;
						batch.draw(obstacle9.image, obstacle9.bounds.x, obstacle9.bounds.y);
						}
					

					
					startTime = System.nanoTime();
				}
						

						

					obstacleType = rand.nextInt(12) +1; // 1-4
					
					
					
				
				
				
				
			}
			
			

			

			
			
			if (obstacle.counter > 0){
				batch.draw(obstacle.image, obstacle.bounds.x, obstacle.bounds.y);
			}
			
			if (obstacle2.counter > 0){
				batch.draw(obstacle2.image, obstacle2.bounds.x, obstacle2.bounds.y);
			}
			
			if (obstacle3.counter > 0){
				batch.draw(obstacle3.image, obstacle3.bounds.x, obstacle3.bounds.y);
			}
			
			if (obstacle4.counter > 0){
				batch.draw(obstacle4.image, obstacle4.bounds.x, obstacle4.bounds.y);
			}
			
			if (obstacle5.counter > 0){
				batch.draw(obstacle5.image, obstacle5.bounds.x, obstacle5.bounds.y);
			}
			
			if (obstacle6.counter > 0){
				batch.draw(obstacle6.image,  obstacle6.bounds.x,  obstacle6.bounds.y);
			}

			if (powerup1.counter > 0){
				batch.draw(powerup1.image,  powerup1.bounds.x,  powerup1.bounds.y);
			}
			
			if (powerdown1.counter > 0){
				batch.draw(powerdown1.image,  powerdown1.bounds.x,  powerdown1.bounds.y);
			}
			
			
			if (obstacle7.counter > 0){
				batch.draw(obstacle7.image,  obstacle7.bounds.x,  obstacle7.bounds.y);
			}
			if (obstacle8.counter > 0){
				batch.draw(obstacle8.image,  obstacle8.bounds.x,  obstacle8.bounds.y);
			}
			if (obstacle9.counter > 0){
				batch.draw(obstacle9.image,  obstacle9.bounds.x,  obstacle9.bounds.y);
			}
			if (obstacle10.counter > 0){
				batch.draw(obstacle10.image,  obstacle10.bounds.x,  obstacle10.bounds.y);
			}
			
			}
		
		if (isGameOver == true){
			
			batch.draw(gameover.image, gameover.bounds.x, gameover.bounds.y);
			batch.draw(tryagainbutton.image, tryagainbutton.bounds.x, tryagainbutton.bounds.y);
			
			estimatedTime = 0;
			estimatedTimeWHOLEGAME = 0;
			startover1 =   true;
			startover2 =   true;
			startover3 =   true;
			startover4 =   true;
			startover5 =   true;
			startover6 =   true;
			startover7 =   true;
			startover8 =   true;
			startover9 =   true;
			startover10 =  true;
			startover11 =  true;
			startover12 =  true;
			
			obstacle.bounds.x = -200;
			obstacle2.bounds.x = -200;
			obstacle3.bounds.x = -200;
			obstacle4.bounds.x = -200;
			obstacle5.bounds.x = -200;
			obstacle6.bounds.x = -200;
			obstacle7.bounds.x = -200;
			obstacle8.bounds.x = -200;
			obstacle9.bounds.x = -200;
			obstacle10.bounds.x = -200;
			powerup1.bounds.x = -200;
			powerdown1.bounds.x = -200;
			
			timeHolder = 0;
			timeHolder2 = 0;
			timeHolder3 = 0;
			
			modifier = 0;
			timedifficulty = 0;	
			

			
		}
		
		batch.end();
		
	}
	
	
	
	public void CheckStartButton(Vector3 touch, OrthographicCamera camera){
		if (Gdx.input.isTouched()){
			touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touch);


			System.out.println("touch.x is "+ touch.x);
			System.out.println("touch.y is "+ touch.y);
			
			if( touch.x > 0 && touch.x < 1920 && touch.y > 0 && touch.y < 1080){
				if (touch.x > button.bounds.x && touch.x < button.bounds.x + 250 && touch.y > button.bounds.y && touch.y < button.bounds.y + 150 ){
					StartButton = true;	
			}
			if(Sound ==true){
				Assets.Start.play();
				Sound = false;
			
			}
				
			}
		}
	}
	
	
	public void CheckTryAgainButton(Vector3 touch, OrthographicCamera camera){
		if (Gdx.input.isTouched()){
			touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touch);
			//System.out.print("x=" +touch.x);
			//System.out.println("y="+touch.y);
			if (touch.x > tryagainbutton.bounds.x && touch.x < tryagainbutton.bounds.x + 250 && touch.y > tryagainbutton.bounds.y && touch.y < tryagainbutton.bounds.y + 150 ){
				TryAgainButton = true;	
				
				flipSwitch = true;
				
				estimatedTime = 0;
				estimatedTimeWHOLEGAME = 0;
				startover1 =   true;
				startover2 =   true;
				startover3 =   true;
				startover4 =   true;
				startover5 =   true;
				startover6 =   true;
				startover7 =   true;
				startover8 =   true;
				startover9 =   true;
				startover10 =  true;
				startover11 =  true;
				startover12 =  true;
				
				obstacle.bounds.x = -200;
				obstacle2.bounds.x = -200;
				obstacle3.bounds.x = -200;
				obstacle4.bounds.x = -200;
				obstacle5.bounds.x = -200;
				obstacle6.bounds.x = -200;
				obstacle7.bounds.x = -200;
				obstacle8.bounds.x = -200;
				obstacle9.bounds.x = -200;
				obstacle10.bounds.x = -200;
				powerup1.bounds.x = -200;
				powerdown1.bounds.x = -200;
				
				timeHolder = 0;
				timeHolder2 = 0;
				timeHolder3 = 0;
				
				modifier = 0;
				timedifficulty = 0;		
				

				
			}
		}
	}
	
	
	
	public void generalUpdate(Vector3 touch, OrthographicCamera camera){
		if(Gdx.input.isTouched()){
			touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touch);
			
			//if ( (touch.x < (bill.bounds.x + 64) ) && ( (touch.x > (bill.bounds.x -64)) ) && (touch.y > (bill.bounds.y -64)) &&  (touch.y < (bill.bounds.y +64))    ){
				//bill.bounds.x = (int)touch.x - 64;
				//bill.bounds.y = (int)touch.y - 64;}
			
			if( touch.x > 0 && touch.x < 1920 && touch.y > 0 && touch.y < 1080){// checks if it within the bounds
				
				if( touch.x < bill.bounds.x + 64){
					bill.bounds.x = bill.bounds.x - 5;
					//System.out.println("touch.x is "+ touch.x);
				}
				
				if( touch.y < bill.bounds.y + 64){
					bill.bounds.y = bill.bounds.y - 5;
				}
				
				if( touch.x > bill.bounds.x + 64){
					bill.bounds.x = bill.bounds.x + 5;
					//System.out.println("touch.x is "+ touch.x);
				}
				
				if( touch.y > bill.bounds.y + 64){
					bill.bounds.y = bill.bounds.y + 5;
					//System.out.println(bill.bounds.y);
				}
			}
			
				


			

			
		}
		
		// fixed bug by adding "&& obstacle.counter > 0" in each if statement
		if(bill.bounds.overlaps(obstacle.bounds) && obstacle.counter > 0){
			System.out.println("COLLISION!!!1");
			Assets.Collision.play();
			isGameOver = true;
			
		}
		
		if(bill.bounds.overlaps(obstacle2.bounds) && obstacle2.counter > 0){
			System.out.println("COLLISION!!!2");
			Assets.Collision.play();
			isGameOver = true;
			
		}
		
		if(bill.bounds.overlaps(obstacle3.bounds) && obstacle3.counter > 0){
			System.out.println("COLLISION!!!3");
			Assets.Collision.play();
			isGameOver = true;
			
		}
		
		if(bill.bounds.overlaps(obstacle4.bounds) && obstacle4.counter > 0){
			System.out.println("COLLISION!!!4");
			Assets.Collision.play();
			isGameOver = true;
			
		}
		
		if(bill.bounds.overlaps(obstacle5.bounds) && obstacle5.counter > 0){
			System.out.println("COLLISION!!!5");
			Assets.Collision.play();
			isGameOver = true;

		}
		
		if(bill.bounds.overlaps(obstacle6.bounds) && obstacle6.counter > 0){
			System.out.println("COLLISION!!!6");
			Assets.Collision.play();
			isGameOver = true;
		}
		
		if(bill.bounds.overlaps(powerup1.bounds) && powerup1.counter > 0){
			System.out.println("POWERUP1!!!");
			Assets.PU.play();
			POWEREDUP = true;
		}
		
		if(bill.bounds.overlaps(powerdown1.bounds) && powerdown1.counter > 0){
			System.out.println("POWER-DOWN1!!!");
			Assets.PD.play();
			POWEREDDOWN = true;
		}
		if(bill.bounds.overlaps(obstacle7.bounds) && obstacle7.counter > 0){
			System.out.println("COLLISION!!!7");
			Assets.Collision.play();
			isGameOver = true;
			
		}
		if(bill.bounds.overlaps(obstacle8.bounds) && obstacle8.counter > 0){
			System.out.println("COLLISION!!!8");
			Assets.Collision.play();
			isGameOver = true;
			
		}
		if(bill.bounds.overlaps(obstacle9.bounds) && obstacle9.counter > 0){
			System.out.println("COLLISION!!!9");
			Assets.Collision.play();
			isGameOver = true;
			
		}
		if(bill.bounds.overlaps(obstacle10.bounds) && obstacle10.counter > 0){
			System.out.println("COLLISION!!!10");
			Assets.Collision.play();
			isGameOver = true;
			
		}
		
	}
	
	public void obstacleUpdate(){
		
		obstacle.bounds.x -= (5 + modifier + timedifficulty);
		if(obstacle.bounds.x < -128){
			startover1 = true;
		}
	}
	
	public void obstacle2Update(){
		
		obstacle2.bounds.x -= 5 + modifier + timedifficulty;
		if(obstacle2.bounds.x < -128){
			startover2 = true;
		}
	}
	
	public void obstacle3Update(){
		
		obstacle3.bounds.x -= 5 + modifier + timedifficulty;
		if(obstacle3.bounds.x < -128){
			startover3 = true;
		}
	}
	
	public void obstacle4Update(){
		
		obstacle4.bounds.x -= 5 + modifier + timedifficulty;
		if(obstacle4.bounds.x < -128){
			startover4 = true;
		}
	}
	
	public void obstacle5Update(){
		
		obstacle5.bounds.x -= 5 + modifier + timedifficulty;
		if(obstacle5.bounds.x < -128){
			startover5 = true;
		}
	}
	
	public void obstacle6Update(){
		
		obstacle6.bounds.x -= 5 + modifier + timedifficulty;
		if(obstacle6.bounds.x < -128){
			startover6 = true;
		}
	}
	
	public void obstacle7Update(){
		
		obstacle7.bounds.x -= 5 + modifier + timedifficulty;
		if(obstacle7.bounds.x < -128){
			startover9 = true;
		}
	}
	
	public void obstacle8Update(){
		
		obstacle8.bounds.x -= 5 + modifier + timedifficulty;
		if(obstacle8.bounds.x < -128){
			startover10 = true;
		}
	}
	
	public void obstacle9Update(){
		
		obstacle9.bounds.x -= 5 + modifier + timedifficulty;
		if(obstacle9.bounds.x < -128){
			startover11 = true;
		}
	}
	
	public void obstacle10Update(){
		
		obstacle10.bounds.x -= 5 + modifier + timedifficulty;
		if(obstacle10.bounds.x < -128){
			startover12 = true;
		}
	}
	
	public void powerup1Update(){
		
		powerup1.bounds.x -= 5 + modifier + timedifficulty;
		if(powerup1.bounds.x < -300){
			startover7 = true;
			//powerup1.holder = true;
		}
	}
	
	public void powerdown1Update(){
		
		powerdown1.bounds.x -= 5 + modifier + timedifficulty;
		if(powerdown1.bounds.x < -300){
			startover8 = true;
			//powerdown1.holder = true;
		}
	}
	
	
	public void cloudBackgroundUpdate(){
		
		cloudbackground.bounds.x -= 2 + (modifier/2) + (timedifficulty/2);
		if(cloudbackground.bounds.x <= -1880){
			recycleBackground = true;

			
		}
	}
	
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
