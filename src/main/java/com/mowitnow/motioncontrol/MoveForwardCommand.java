package com.mowitnow.motioncontrol;

import com.mowitnow.mowbot.LawnArea;
import com.mowitnow.mowbot.MowBot;

public class MoveForwardCommand implements Command {
	private MowBot mowBot;
	private Position previousPosition;

	public MoveForwardCommand(MowBot mowBot) {
		this.mowBot = mowBot;
		previousPosition = new Position();
	}

	public Position getPreviousPosition() {
		return previousPosition;
	}

	public void setPreviousPosition(Position previousPosition) {
		this.previousPosition = previousPosition;
	}

	public void execute() {
		/**
		 * We store the current position of the lawnmower. If the point we're
		 * targeting is unreachable (out of the lawn area) after we made the
		 * move, we restore the previous position of the lawnmower
		 */
		previousPosition.setX(mowBot.getPosition().getX());
		previousPosition.setY(mowBot.getPosition().getY());
		previousPosition.setOrientation(mowBot.getPosition().getOrientation());

		int x = mowBot.getPosition().getX();
		int y = mowBot.getPosition().getY();

		if (mowBot.getPosition().getOrientation().equals(CardinalPoint.N))
			mowBot.getPosition().setY(y + 1);
		else if (mowBot.getPosition().getOrientation().equals(CardinalPoint.E))
			mowBot.getPosition().setX(x + 1);
		else if (mowBot.getPosition().getOrientation().equals(CardinalPoint.S))
			mowBot.getPosition().setY(y - 1);
		else if (mowBot.getPosition().getOrientation().equals(CardinalPoint.W))
			mowBot.getPosition().setX(x - 1);

		/**
		 * We check whether current position is within the lawn area or not : in
		 * the latter case, we restore the previous position of the lawnmower
		 */
		if (!isCurrentPositionReachable()) {
			undo();
		}
	}

	/**
	 * undo() restores the previous state of our mowbot (its previous position)
	 */
	public void undo() {
		mowBot.getPosition().setX(previousPosition.getX());
		mowBot.getPosition().setY(previousPosition.getY());
		mowBot.getPosition().setOrientation(previousPosition.getOrientation());
	}

	public boolean isCurrentPositionReachable() {
		if ((mowBot.getPosition().getX() < LawnArea.DOWN_LEFT_MOST_X)
				|| (mowBot.getPosition().getX() > mowBot.getLawnArea()
						.getUpperRightMostX())
				|| (mowBot.getPosition().getY() < LawnArea.DOWN_LEFT_MOST_Y)
				|| (mowBot.getPosition().getY() > mowBot.getLawnArea()
						.getUpperRightMostY()))
			return false;

		return true;
	}
}
