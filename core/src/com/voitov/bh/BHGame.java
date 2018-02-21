package com.voitov.bh;

import com.badlogic.gdx.Game;
import com.voitov.bh.screens.ScreenManager;
import com.voitov.bh.textures.TextureManager;
import com.voitov.bh.world.staticc.GameWorld;
import com.voitov.bh.world.staticc.GameWorldProvider;


//АРХИТЕКТУРА:
//1) ScreenModel задаёт полное состояние графических объектов на экране (модель ни о ком не знает)
//2) При открытии screen, этот пересоздает все стэйджи в соответствии со screenModel (screen знает обо всех)
//3) Стэйджы обращаются к screen, чтобы изменить другие стэйджы (они видят ScreenController)

//10 мин
//7) Вынести кнопки ui в отдельную группу. Убирать при энкаунтере, на их место кнопку "убить монстра"

//10 мин
//8) Добавить случайные энкаунтеры
	
//9) Сохранение прогресса при выполнении задания, сохранение позиции космоса при посадке на планету 
//11) Бой со встреченным созданием: стрельба по таймеру, кнопка Супер-удар

//Надо ли сейчас лезть в инвентарь?..
//думаю, нет. Просто держать список предметов (можно с картинкой).

//12) Делать насыщенную первую главу, додумывать, как привнести уникальности

//Полчаса
//13) Инвентарь (Делать по старой картинке: слоты для оборудования, слоты для инвентаря)

//   Отдельные локации в городах: магазин, арена, казино. 

//Справка по libgdx:
//   
//   1) Надо бы разобраться со скинами и 9patch
//   2) Надо бы разобраться с Dialog, Table
//   Отдельные Screen для логически разных экранов, отдельные Stage для всяких всплывающих окошек
//   Чтобы обрабатывать нажатие на Actor или Group, надо задать ему положение и размеры.
//   Аналог панели из wicket - group. Однако, у group нет alignment.
//	 Разные stage необходимо использовать для UI, когда движется камера (не наш случай).
//   ((Нам все-равно придется использовать stage для UI, потому что у нас динамически меняется z-index объектов...))
//   Неправда, можно просто разложить по разным группам!!
//   Есть способ заставить inputListener слушать только конкретный stage.
//   !! Возможно, stage не стоит использовать для попапов !!
//   Пишут, что для popup`ов надо использовать Dialog (https://gamedev.stackexchange.com/questions/84373/how-do-i-make-a-pop-up-window-with-scene2d)
//   Какой-то SkinComposer: (https://ray3k.wordpress.com/software/skin-composer-for-libgdx/)
//   ?? Пока непонятно, кто такой Skin, и зачем он нужен??
//   FlexiblePanel надо заменить на 9patch (http://www.libgdx.ru/2014/10/ninepatches.html)
//	 Для верстки UI лучше использовать Table.

/** Входная точка приложения. Здесь инициализируются все синглтоны приложения. */

public class BHGame extends Game {
	
	public GameWorld gameWorld; 
	public ScreenManager screenManager;
	public TextureManager textureManager;
	
	@Override
	public void create () {
		gameWorld = GameWorldProvider.getGameWorld();
		textureManager = new TextureManager();
		screenManager = new ScreenManager(this);
		screenManager.createScreens();
		screenManager.toLoadingScreen();
	}

	@Override
	public void dispose () {
		screenManager.dispose();
		textureManager.dispose();
	}

}
